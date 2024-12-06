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

    public String getPaymentInfo(){
        return String.format("Cardholder: %s%nCardnumber: %s", cardHolder, cardNumber);
    }

}
