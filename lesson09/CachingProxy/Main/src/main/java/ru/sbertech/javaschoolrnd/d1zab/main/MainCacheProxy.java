package ru.sbertech.javaschoolrnd.d1zab.main;

import ru.sbertech.javaschoolrnd.d1zab.cacheproxy.CacheProxy;
import ru.sbertech.javaschoolrnd.d1zab.cacheproxy.CacheType;
import ru.sbertech.javaschoolrnd.d1zab.cacheproxy.IService;
import ru.sbertech.javaschoolrnd.d1zab.cacheproxy.Service;

import java.io.File;

public class MainCacheProxy {
    //Каталог хранения кэша вычислений
    private static final String CACHE_PATH = "history" + File.separator;
    private static final CacheType DEFAULT_CACHE_TYPE = CacheType.FILE;

    public static void main(String[] args) {
        CacheProxy cacheProxy = new CacheProxy(CACHE_PATH, DEFAULT_CACHE_TYPE);

        IService service = cacheProxy.cache(new Service());

        System.out.println("\n>Метод doHardWork");
        System.out.println("Результат: " + service.doHardWork("work2",422));
        System.out.println("Результат: " + service.doHardWork("work2",422));
        System.out.println("Результат: " + service.doHardWork("work1",4));
        System.out.println("Результат: " + service.doHardWork("work1",4));

        System.out.println("\n>Метод run");
        System.out.println("Результат: " + service.run("Test"));
        System.out.println("Результат: " + service.run("Test"));
        System.out.println("Результат: " + service.run("Test Test"));
        System.out.println("Результат: " + service.run("Test Test"));

    }
}
