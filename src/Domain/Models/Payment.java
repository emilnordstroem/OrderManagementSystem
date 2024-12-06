package Domain.Models;

public class Payment {
    private String cardHolder;
    private String cardNumber;

    public Payment(Customer customer, String cardNumber){
        this.cardHolder = customer.getFullName();
        this.cardNumber = cardNumber;
    }

    public String getPaymentInfo(){
        return String.format("Cardholder: %s%nCardnumber: %s", cardHolder, cardNumber);
    }
}
