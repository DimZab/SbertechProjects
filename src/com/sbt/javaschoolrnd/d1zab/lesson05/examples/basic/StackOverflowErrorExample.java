package com.sbt.javaschoolrnd.d1zab.lesson05.examples.basic;

public class StackOverflowErrorExample {

    private static void doSomething() {
        doSomething();
    }

    public static void main(String[] args) {
        doSomething();
    }

}
