package com.sbt.javaschoolrnd.d1zab.lesson08ModuleBuildToolsTesting.ArrayIteratorJunit3.src.main;


public class App {
    public static int ARR_SIZE = 10;

    public static void main( String[] args )
    {
        ArrayWithIterator<String> myArray = new ArrayWithIterator<String>(ARR_SIZE);

        for (int i = 0; i < ARR_SIZE; i++) {
            myArray.put(i, "String " + i);
        }

        System.out.println("Print the contents of the array with Iterator");
        for (String s : myArray) {
            System.out.println(s);
        }
    }
}
