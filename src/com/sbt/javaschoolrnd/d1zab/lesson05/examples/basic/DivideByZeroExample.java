package com.sbt.javaschoolrnd.d1zab.lesson05.examples.basic;

public class DivideByZeroExample {

    private static void badMethod() {
        System.out.print(1 / 0);
    }

    private static void doSomething() {
        badMethod();
    }

    public static void main(String[] args) {
        doSomething();
    }

}
