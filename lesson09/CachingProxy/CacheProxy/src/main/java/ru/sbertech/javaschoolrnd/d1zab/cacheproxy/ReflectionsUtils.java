package ru.sbertech.javaschoolrnd.d1zab.cacheproxy;

/**
   * By name of the wrapper class (Byte, Short, Integer, Long, Float, Double)
   * returns the corresponding primitive type.
   * If the parameter is not a wrapper class, the parameter returns without changes.
 */
public class ReflectionsUtils {
    public static Class GetPrimitiveClass(final Class wrapperClass) {
        if (wrapperClass == Byte.class) return byte.class;
        if (wrapperClass == Short.class) return short.class;
        if (wrapperClass == Integer.class) return int.class;
        if (wrapperClass == Long.class) return long.class;
        if (wrapperClass == Float.class) return float.class;
        if (wrapperClass == Double.class) return double.class;

        return wrapperClass;
    }
}
