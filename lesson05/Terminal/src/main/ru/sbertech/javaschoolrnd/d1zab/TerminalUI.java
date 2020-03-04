package ru.sbertech.javaschoolrnd.d1zab;

import java.io.IOException;
import java.util.Scanner;

public class TerminalUI {

    private TerminalImpl terminal = new TerminalImpl(new TerminalServer(), new CardAndPinValidator());

    private Scanner in = new Scanner(System.in);

    public void start() {

        while (true) {
            String cardNumber = cardMenu();
            if (!cardNumber.isEmpty())
                operationMenu(cardNumber);

            break;
        }
        System.out.println("\nPlease, Take your card");
    }

    private String cardMenu() {

        boolean flag = true;

        System.out.print("\nPlease, insert your card (enter number or q to complete the work): ");
        String cardNumber = in.nextLine().replaceAll("\\s+", "");

        while (flag) {
            if (cardNumber.equalsIgnoreCase("q")) return "";

            if (!terminal.checkCardNumber(cardNumber)) {
                System.out.println("Invalid card number (enter a number or q to complete the job): ");
                cardNumber = in.nextLine().replaceAll("\\s+", "");
            }

            else flag = false;
        }


        flag = true;

        while (flag) {
            System.out.print("Enter your PIN (or 'q' to complete the job): ");
            String pin = in.nextLine().replaceAll("\\s+", "");

            if (pin.equalsIgnoreCase("q")) return "";

            try {
                if (!terminal.checkPin(cardNumber, pin)) {
                    System.out.println("Invalid card PIN ");
                    continue;
                }
            } catch (AccountIsLockedException e) {
                System.out.println("Account is blocked. Seconds remaining before unlocking: " + e.getMessage());
                continue;
            }
            flag = false;
        }
        return cardNumber;
    }


    private void operationMenu(String cardNumber) {
        while (true) {
            System.out.print("\nPlease, choose operation you want to proceed: \n"+
                    "1. Check card balance \n" +
                    "2. Withdraw cash \n" +
                    "3. Deposit cash \n" +
                    "4. Shut down \n" +
                    "Enter the number of the desired operation [1-4]: ");

            int operation = in.nextInt();

            try {
                if (operation == 1) getBalance(cardNumber);
                if (operation == 2) getMoney(cardNumber);
                if (operation == 3) putMoney(cardNumber);
                if (operation == 4) return;

            } catch (SecurityException e) {
                System.out.println("To get started, you must enter the PIN code.");
            } catch (AccountIsLockedException e) {
                System.out.println("Account is blocked. Seconds remaining before unlocking: " + e.getMessage());
            } catch (InsufficientFundsExceptions e) {
                System.out.println("Insufficient funds in the account. Operation failed.");
            } catch (IllegalArgumentException e) {
                System.out.println("The amount must be a multiple of 100. The operation has not been completed.");
            } catch (IOException e) {
                System.out.println("We apologize. There are communication problems, try to repeat the operation.");
            }
        }
    }

    private void getBalance(String cardNumber) throws IOException {
        System.out.println("\nCard Balance:" + terminal.checkBalance(cardNumber));
    }

    private void getMoney(String cardNumber) throws IOException {
        System.out.println("\nCash withdrawal");
        System.out.println("Enter the amount of cash multiple of 100: ");
        int amount = in.nextInt();
        terminal.getMoney(cardNumber, amount);
        System.out.println("The operation was successful, take the money.");
    }

    private void putMoney(String cardNumber) throws IOException {
        System.out.println("\nDeposit cash");
        System.out.println("Enter the amount of cash multiple of 100: ");
        int amount = in.nextInt();
        terminal.putMoney(cardNumber, amount);
        System.out.println("The operation was successful, the money credited.");
    }
}


