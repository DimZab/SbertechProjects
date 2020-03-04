package ru.sbertech.javaschoolrnd.d1zab;

import java.io.IOException;

public class TerminalImpl implements Terminal {

    private final TerminalServer server;
    private final CardAndPinValidator cardAndPinValidator;

    private final LockHelper lockHelper = new LockHelper();

    private int pinErrorCount = 0;
    private int cardNumberErrorCount = 0;

    public TerminalImpl(TerminalServer server, CardAndPinValidator cardAndPinValidator) {
        this.server = server;
        this.cardAndPinValidator = cardAndPinValidator;
    }

    public boolean checkCardNumber(String cardNumber) {

        if (lockHelper.isLocked())
            throw new AccountIsLockedException((int) (Math.ceil(lockHelper.getCoutdown() / 1000.0)));

        if (cardAndPinValidator.validateCardNumber(cardNumber)) {
            cardNumberErrorCount = 0;
            return true;
        }
        return false;

        // We can lock terminal if entered card Number is invalid

//        cardNumberErrorCount++;
//        if (cardNumberErrorCount == 2) {
//            lockHelper.lock();
//            cardNumberErrorCount = 0;
//        }
//
//        return false;
    }


    public boolean checkPin(String cardNumber, String pin) {

        if (lockHelper.isLocked())
            throw new AccountIsLockedException((int) (Math.ceil(lockHelper.getCoutdown() / 1000.0)));

        if (cardAndPinValidator.validateCardAndPin(cardNumber, pin)) {
            pinErrorCount = 0;
            return true;
        }

        pinErrorCount++;
        if (pinErrorCount == 2) {
            lockHelper.lock();
            pinErrorCount = 0;
        }

        return false;
    }


    @Override
    public void getMoney(String cardNumber, long amount) throws IOException {
        if (!cardAndPinValidator.isAuthorized)
            throw new SecurityException("The user is not authorized. Please, enter the PIN code");
        if (lockHelper.isLocked())
            throw new AccountIsLockedException((int) (Math.ceil(lockHelper.getCoutdown() / 1000.0)));
        if (amount % 100 != 0)
            throw new IllegalArgumentException("Amount must be a multiple of 100");

        server.getMoney(cardNumber, amount);
    }

    @Override
    public void putMoney(String cardNumber, long amount) throws IOException {
        if (!cardAndPinValidator.isAuthorized)
            throw new SecurityException("The user is not authorized. Please, enter the PIN code");
        if (lockHelper.isLocked())
            throw new AccountIsLockedException((int) (Math.ceil(lockHelper.getCoutdown() / 1000.0)));
        if (amount % 100 != 0)
            throw new IllegalArgumentException("Amount must be a multiple of 100");

        server.putMoney(cardNumber, amount);
    }

    @Override
    public long checkBalance(String cardNumber) throws IOException {
        if (!cardAndPinValidator.isAuthorized)
            throw new SecurityException("The user is not authorized. Please, enter the PIN code");
        if (lockHelper.isLocked())
            throw new AccountIsLockedException((int) (Math.ceil(lockHelper.getCoutdown() / 1000.0)));

        return server.checkBalance(cardNumber);
    }

    /**
     * Helper class tracking account lockout time
     */

    private static class LockHelper {
        private static final long lockInterval = 5000;
        long lockTime = -1;

        boolean isLocked() {
            if (lockTime == -1) return false; //Was not blocked
            if (lockTime + lockInterval > System.currentTimeMillis()) {
                return true; //Interval is not yet completed
            }
            //Interval is completed
            lockTime = -1;
            return false;
        }

        void lock() {
            if (lockTime != -1) return; //Already blocked
            lockTime = System.currentTimeMillis();
        }

        //Returns the time in milliseconds before unlocking
        long getCoutdown() {
            if (lockTime != -1)
                return lockTime + lockInterval - System.currentTimeMillis();
            return 0;
        }
    }
}

