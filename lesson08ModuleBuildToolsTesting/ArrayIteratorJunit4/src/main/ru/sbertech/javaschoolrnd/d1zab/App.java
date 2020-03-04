package ru.sbertech.javaschoolrnd.d1zab;


public class App {
    public static int ARR_SIZE = 10;

    public static void main(String[] args) {
        ArrayWithIteratorJu3<String> myArray = new ArrayWithIteratorJu3<String>(ARR_SIZE);

        for (int i = 0; i < ARR_SIZE; i++) {
            myArray.put(i, "String " + i);
        }

        System.out.println("Print the contents of the array with Iterator");
        for (String s : myArray) {
            System.out.println(s);
        }
    }
}
