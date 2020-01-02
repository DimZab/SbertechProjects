package com.sbt.javaschoolrnd.d1zab.lesson11;


public class SomeTask implements Runnable {
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.print("#%d(%s) " + i + Thread.currentThread().getName());
        }
    }
}