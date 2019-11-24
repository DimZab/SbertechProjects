package com.sbt.javaschoolrnd.d1zab.lesson04;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T> {

    // All keys are Objects,
    // And their values are counters
    private Map<T, Integer> mapCounter = new HashMap<>();

    @Override
    public void add(T o) {
        Integer count = 1;
        if (mapCounter.containsKey(o)){
            count += mapCounter.get(o);
        }
        mapCounter.put(o, count);
    }


    @Override
    public int getCount(T o) {
        Integer count = mapCounter.get(o);
        int result;

        // if value is not found
        if (count == null) result = 0;
        else result = count;
        return result;
    }


    @Override
    public int remove(T o) {
        Integer count = mapCounter.remove(o);
        int result;

        // if value is not found
        if (count == null) result = 0;
        else result = count;
        return result;
    }


    @Override
    public int size() {
        return mapCounter.size();
    }


    @Override
    public void addAll(CountMap<T> source) {
        Map<T, Integer> src = source.toMap();

        for (T key : src.keySet() ) {
            Integer count = src.get(key);
            count += getCount(key);
            mapCounter.put(key, count);
        }
    }


    @Override
    public Map<T, Integer> toMap() {
        return mapCounter;
    }


    @Override
    public void MaptoMap(Map<T, Integer> destination) {
        for (T key : mapCounter.keySet()) {
            Integer count = mapCounter.get(key);

            if (destination.containsKey(key)) count += destination.get(key);
            destination.put(key, count);
        }
    }
}