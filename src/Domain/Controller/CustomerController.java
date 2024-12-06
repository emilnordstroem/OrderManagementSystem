package Domain.Controller;

import Domain.Models.*;
import Storage.CustomerStorage;
import Storage.IDStorage;

import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerController {

    public static Customer createCustomer(String firstName, String lastName, LocalDate dateOfBirth, Address address, Payment payment){
        System.out.println("createCustomer() called in CustomerController...");
        Customer customer = new Customer(firstName, lastName, dateOfBirth, address, payment);
        CustomerStorage.addCustomer(customer);
        return customer;
    }

    public static double getTotalSpending(Customer customer){
        double result = 0;
        ArrayList<Order> customerOrders = customer.getOrders();
        for(Order order : customerOrders){
            result += order.getPrice();
        }
        return result;
    }

    public static void inactiveCustomerAccount(Customer customer){
        System.out.println("inactiveCustomerAccount() called in CustomerController...");
        customer.inactiveCustomerAccount();
    }

    public static void reactivateCustomerAccount(Customer customer){
        System.out.println("reactivateCustomerAccount() called in CustomerController...");
        if(customer.getCustomerStatus().equals(CustomerStatus.INACTIVE)){
            customer.reactivateCustomerAccount();
            System.out.println("updateCustomerStorage() called in CustomerController...");
            CustomerStorage.updateCustomerStorage(customer);
        }
    }

    public static void closeCustomerAccount(Customer customer){
        System.out.println("closeCustomerAccount() called in CustomerController...");
        if(customer.getCustomerStatus().equals(CustomerStatus.INACTIVE)){
            customer.closeCustomerAccount();
            System.out.println("updateCustomerStorage() called in CustomerController...");
            CustomerStorage.updateCustomerStorage(customer);
        }
    }

    public static void removeCustomer(Customer customer){
        if(customer.getCustomerStatus().equals(CustomerStatus.CLOSED)){
            System.out.println("removeCustomer() called in CustomerController...");
            CustomerStorage.removeCustomer(customer);
            IDStorage.addCustomerID(customer.getId());
        }
    }

}
