package ru.sbertech.javaschoolrnd.d1zab;

public class HappyMarriage {
    public static void main(String[] args) {

        // Adding 3 males and 3 females and trying them to marry

        Person Andrei = new Person(true, "Andrei");
        Person Denis = new Person(true, "Denis");
        Person Ivan = new Person (true, "Ivan");

        Person Anna = new Person (false, "Anna");
        Person Diana = new Person (false, "Diana");
        Person Maria = new Person (false, "Maria");


        Andrei.marry(Anna);
        Andrei.marry(Denis);

        Denis.marry(Diana);
        Anna.marry(Diana);


        Andrei.marry(Diana);

        System.out.println(Andrei.seeStats());
        System.out.println(Anna.seeStats());


    }
}
