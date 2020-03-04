package ru.sbertech.javaschoolrnd.d1zab;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TerminalServer implements Terminal {
    //Card Database: Card Number - Balance
    private Map<String, Long> cardDB = new HashMap<>();

    public TerminalServer() {
        //Filling Database
        cardDB.put("1111111111111111", 100000L);
        cardDB.put("2222222222222222", 200000L);
        cardDB.put("3333333333333333", 300000L);
        cardDB.put("4444444444444444", 400000L);
        cardDB.put("5555555555555555", 500000L);
    }

    @Override
    public long checkBalance (String cardNumber) throws IOException {
        ConnectionErrorSimulator();
        return cardDB.get(cardNumber);
    }

    @Override
    public void getMoney(String cardNumber, long amount) throws IOException {
        ConnectionErrorSimulator();
        long balance = cardDB.get(cardNumber);
        long newBalance = balance - amount;
        if (newBalance < 0) throw new InsufficientFundsExceptions("Sorry, Not enough funds in the account");
        cardDB.put(cardNumber, newBalance);
    }

    @Override
    public void putMoney(String cardNumber, long amount) throws IOException {
        ConnectionErrorSimulator();
        long balance = cardDB.get(cardNumber);
        long newBalance = balance + amount;
        cardDB.put(cardNumber, newBalance);
    }


//     The method simulates communication problems, with a probability of 25% throws an IOException

    private void ConnectionErrorSimulator() throws IOException {
        final Random rnd = new Random();
        if (rnd.nextInt(4) == 2) throw new IOException("We apologize. Network problems...");
    }
}
