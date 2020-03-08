package ru.sbertech.javaschoolrnd.d1zab.cacheproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.*;

public class ProxyHandler implements InvocationHandler {

    private final Object delegate;
    private final String cachePath;
    private final CacheType defaultCacheType;

    //Кэш:
    //Ключ - имя кэшируемого метода
    //Значение - map, где key - списки аргументов, значения - результат работы кэшируемой функции.
    private Map<String, Map<ArrayList, Object>> cache = new HashMap<>();

    public ProxyHandler(Object delegate, String cachePath, CacheType defaultCacheType) {
        this.delegate = delegate;
        this.cachePath = cachePath;
        this.defaultCacheType = defaultCacheType;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("\nCalling function " + method.getName() + " with args " + Arrays.toString(args));

        //If we need caching
        if (method.isAnnotationPresent(Cache.class)) {
            Cache an = method.getAnnotation(Cache.class);
//            // For debug
//            System.out.println("Аннотации метода: @Cache(cacheType=" + an.cacheType() +
//                    ", fileNamePrefix=" + an.fileNamePrefix() +
//                    ", zip=" + an.zip() +
//                    ", identityBy=" + Arrays.toString(an.identityBy()) + ")" +
//                    ", listLength=" + an.listLength() + ")");

            // Form the name of the cache file for writing / reading
            String prefix = (an.fileNamePrefix().length() > 0) ? an.fileNamePrefix() : method.getName();
            String fileName = this.cachePath + prefix + ".cache";

            Map<ArrayList, Object> methodCache = new HashMap<>();

            if (an.cacheType() == CacheType.FILE) {
                // If there is no cache for this method, try loading from disk
                if (!this.cache.containsKey(method.getName())) {

                    Object loadedCache = SerializableUtils.deserialize(fileName, an.zip());

                    if (loadedCache != null) {
                        methodCache = (Map<ArrayList, Object>) loadedCache;
                        System.out.println("cache for method " + method.getName() + " был загружен из файла " + fileName);
                        this.cache.put(method.getName(), (Map<ArrayList, Object>) methodCache);
                    }
                }
            }

            // List of identification classes of arguments from the annotation
            List<Object> identityArr = Arrays.asList(an.identityBy());

            // Choose Identity Arguments
            ArrayList keys = new ArrayList();
            for (Object arg : args) {
                if (identityArr.isEmpty())
                    keys.add(arg); // If the identityBy array was not specified, add all arguments
                else if (identityArr.contains(ReflectionsUtils.GetPrimitiveClass(arg.getClass()))) {
                    System.out.println("\tWe identify the cache by a parameter: " + arg.getClass());
                    keys.add(arg);  //Otherwise, only those specified in the annotation
                }
            }

            //If our method is in the cache
            if (this.cache.containsKey(method.getName())) {
                // Find the cache of a specific method
                methodCache = this.cache.get(method.getName());
                // If there is a cache with the necessary arguments
                if (methodCache.containsKey(keys)) {
                    //  Return The Cached Result
                    System.out.println("For method " + method.getName() + " ключ " + keys + " найден в кэше, достаем результат из кэша");
                    return methodCache.get(keys);
                }
            }

            // Calculate the result and put it in the cache
            Object returnValue = method.invoke(delegate, args);

            if (an.listLength() != -1 && List.class.isAssignableFrom(returnValue.getClass())) {
                //  Cut the list to the desired length, if necessary
                // sublist is not serializable, so create a new one

                List newList = new ArrayList(((List) returnValue).subList(0, an.listLength()));
                returnValue = newList;
            }

            System.out.println("Put in a cache |" + method.getName() + "| " + keys + " : " + returnValue);
            methodCache.put(keys, returnValue);
            this.cache.put(method.getName(), methodCache);

            if (an.cacheType() == CacheType.FILE) {
                System.out.println("Cache is bing written in a file " + fileName);
                SerializableUtils.serialize(this.cache.get(method.getName()), fileName, an.zip());
            }

            return returnValue;
        }
        // If the method is not in a cache, so just calculate and return the result
        return method.invoke(delegate, args);
    }
}
