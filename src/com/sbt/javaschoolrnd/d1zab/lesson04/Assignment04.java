package com.sbt.javaschoolrnd.d1zab.lesson04;

import com.sbt.javaschoolrnd.d1zab.lesson04.CountMap;
import com.sbt.javaschoolrnd.d1zab.lesson04.CountMapImpl;

public class Assignment04 {
    public static void main(String[] args) {
        CountMap<Integer> map = new CountMapImpl<>();


        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);


        int counter = map.getCount(5);  // 2
        System.out.println(counter);

        counter = map.getCount(6);      // 1
        System.out.println(counter);

        counter = map.getCount(10);     // 3
        System.out.println(counter);

    }
}