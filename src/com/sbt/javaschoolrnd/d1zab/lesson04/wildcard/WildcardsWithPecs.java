package com.sbt.javaschoolrnd.d1zab.lesson04.wildcard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WildcardsWithPecs {

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<T>();
    }

    public static <T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }

    public static <T> List<T> limit(List<? extends T> source, int size) {
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<? super T> source, List<? extends T> c2) {
        source.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {

        return false;
    }

    public static <T> List <T> range(List<? extends T> list, T min, T max) {
    }

    public static <T> List <T> range(List<? extends T> list, T min, T max, Comparator comparator) {
    }
}
