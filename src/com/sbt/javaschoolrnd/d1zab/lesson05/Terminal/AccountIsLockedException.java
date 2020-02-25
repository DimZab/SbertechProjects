package com.sbt.javaschoolrnd.d1zab.lesson05.Terminal;

public class AccountIsLockedException extends IllegalStateException {
    public AccountIsLockedException(int sec) {

        super(String.valueOf(sec));
    }
}