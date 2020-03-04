package ru.sbertech.javaschoolrnd.d1zab;

import java.util.HashMap;
import java.util.Map;

public class CardAndPinValidator {
    //Data Storage: № of card and Pin
    private Map<String, String> DataStorage = new HashMap<>();

    //Checking for correct account № and Pin input
    boolean isAuthorized = false;
    boolean validCardNumber = false;
    // We also can lock terminal if entered card Number is invalid

    public CardAndPinValidator() {
        DataStorage.put("1111111111111111", "1111");
        DataStorage.put("2222222222222222", "2222");
        DataStorage.put("3333333333333333", "3333");
        DataStorage.put("4444444444444444", "4444");
        DataStorage.put("5555555555555555", "5555");
    }


    boolean validateCardNumber(String cardNumber) {
        if (cardNumber.length() == 16 & DataStorage.containsKey(cardNumber)) {
            validCardNumber = true;
        }
        return validCardNumber;
    }


    boolean validateCardAndPin(String cardNumber, String pin) {
        if (pin.length() != 4) return false;
        isAuthorized = validCardNumber & DataStorage.get(cardNumber).equals(pin);

        return isAuthorized;
    }
}