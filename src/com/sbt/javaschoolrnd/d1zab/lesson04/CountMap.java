package com.sbt.javaschoolrnd.d1zab.lesson04;

import java.util.Map;

public interface CountMap<T> {
    void add(T o);

    int getCount(T o);

    int remove(T o);

    int size();

    void addAll(CountMap<T> o);

    Map<T, Integer> toMap();

    void MaptoMap(Map<T, Integer> destination);
}
