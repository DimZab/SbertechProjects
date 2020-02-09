package com.sbt.javaschoolrnd.d1zab.lesson08ModuleBuildToolsTesting.ArrayIteratorJunit4.src.test;

import com.sbt.javaschoolrnd.d1zab.lesson08ModuleBuildToolsTesting.ArrayIteratorJunit4.src.main.ArrayWithIterator;
import org.junit.Test;

import java.util.Iterator;

public class ArrayWithIteratorExceptionTest {

    ArrayWithIterator<Integer> array = new ArrayWithIterator<Integer>(0);

    @Test(expected = IllegalArgumentException.class)
    public void put() throws Exception {
        array.put(1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void get() throws Exception {
        array.get(1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iterator() throws Exception {
        Iterator<Integer> iterator = array.iterator();
        iterator.remove();
    }

}