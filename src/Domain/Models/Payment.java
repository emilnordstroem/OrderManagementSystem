package Domain.Models;

import Storage.IDStorage;

import java.util.Random;

public class Payment {
    private String cardHolder;
    private String cardNumber;

    public Payment(String fullName, String cardNumber){
        this.cardHolder = fullName;
        this.cardNumber = cardNumber;
    }

    public Payment(String fullName){
        this.cardHolder = fullName;
        this.cardNumber = generateID();
    }

    protected String generateID(){
        String id = String.valueOf(new Random().nextLong(111_111_111, 999_999_999) + 1);
        while(IDStorage.cardNumberAlreadyExist(id)){
            id = String.valueOf(new Random().nextLong(111_111_111, 999_999_999) + 1);
        }
        IDStorage.addCardNumber(id);
        return id;
    }

    public String getCardHolder(){
        return cardHolder;
    }

    public String getCensoredCardNumber(){
        StringBuilder censoredCardNumber = new StringBuilder();
        for(int index = cardNumber.length() - 1; index >= (cardNumber.length() - 3); index--){
            char character = cardNumber.charAt(index);
            censoredCardNumber.append(character);
        }
        return String.format("*** *** %s", censoredCardNumber);
    }

}
