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
        if (size < source.size()) {
            return (List<T>) source.subList(0, size);
        } else return (List<T>) source;
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
        for (T o : c2) {
            if (c1.contains(o)) {
                return true;
            }
        }

        return false;
    }

    public static <T extends Comparable<T>> List<? super T> range(List<? extends T> c, T min, T max) {
        List<T> result = new ArrayList<>();
        for (T item : c) {
            if (item.compareTo(min) > 0 && item.compareTo(max) < 0)
                result.add(item);
        }

        return result;
    }

    public static <T> List range(List<? extends T> list, T min, T max, Comparator comparator) {
        List<T> newlist = new ArrayList<>();

        if (list.isEmpty()) {
            return null;
        } else {
            for (T item : list) {
                if ((comparator.compare(min, item) >= 0) & (comparator.compare(min, item) <= 0)) {

//                The return value(not type, the type is int) tells the caller(the thing sorting the data):
//                - 1 : o1 < o2  ;
//                0   : o1 == o2 ;
//                + 1 : o1 > o2

                    newlist.add(item);
                }
            }
            return newlist;
        }
    }

    public int compareTo(Object o) {
        return 0;
    }

//    @Override
//    public int compare(Object o1, Object o2) {
//        return 0;
//    }
}