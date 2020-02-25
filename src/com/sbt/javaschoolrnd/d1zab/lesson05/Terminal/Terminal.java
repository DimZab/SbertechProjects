package com.sbt.javaschoolrnd.d1zab.lesson05.Terminal;

import java.io.IOException;

public interface Terminal {
    long checkBalance(String cardNumber) throws IOException;
    void getMoney(String cardNumber, long amount) throws IOException;
    void putMoney(String cardNumber, long amount) throws IOException;
}
