package Domain.Models;

import Storage.IDStorage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Customer {
    private String id;
    private CustomerStatus customerStatus;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String email;
    private LocalDate dateOfBirth;
    private Address address;
    private final ArrayList<Order> orders = new ArrayList<>();
    private Payment payment;

    public Customer(String firstName, String lastName, String phoneNo, String email, LocalDate dateOfBirth, Address address, Payment payment) {
        this.id = generateID();
        this.customerStatus = activateCustomerAccount();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.payment = payment;
    }

    private String generateID(){
        String id = String.valueOf(new Random().nextInt(111, 999) + 1);
        while(IDStorage.customerIdentificationAlreadyExist(id)){
            id = String.valueOf(new Random().nextInt(111, 999) + 1);
        }
        IDStorage.addCustomerID(id);
        return id;
    }

    public ArrayList<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    private CustomerStatus activateCustomerAccount(){
        return CustomerStatus.ACTIVE;
    }

    public void inactiveCustomerAccount() {
        this.customerStatus = CustomerStatus.INACTIVE;
        System.out.println("Customer is now inactive");
    }

    public void reactivateCustomerAccount(){
        this.customerStatus = CustomerStatus.ACTIVE;
        System.out.println("Customer is now reactivated");
    }

    public void closeCustomerAccount(){
        this.customerStatus = CustomerStatus.CLOSED;
        System.out.println("Customer is now closed");
    }

    public CustomerStatus getCustomerStatus() {
        return customerStatus;
    }

    public void addOrder(Order order){
        System.out.printf("%s added to Customers list of orders", order.getId());
        orders.add(order);
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName(){
        return String.format("%s %s", firstName, lastName);
    }

    public Address getAddress() {
        return address;
    }
}
