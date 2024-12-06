package Domain.Controller;

import Domain.Models.Address;
import Domain.Models.Customer;
import Domain.Models.CustomerStatus;
import Domain.Models.Payment;
import Storage.CustomerStorage;
import Storage.IDStorage;

import java.time.LocalDate;

public class CustomerController {

    private static void createCustomer(String firstName, String lastName, LocalDate dateOfBirth, Address address, Payment payment){
        System.out.println("createCustomer() called in CustomerController...");
        Customer customer = new Customer(firstName, lastName, dateOfBirth, address, payment);
        CustomerStorage.addCustomer(customer);
    }

    private static void inactiveCustomerAccount(Customer customer){
        System.out.println("inactiveCustomerAccount() called in CustomerController...");
        customer.inactiveCustomerAccount();
    }

    private static void reactivateCustomerAccount(Customer customer){
        System.out.println("reactiveCustomerAccount() called in CustomerController...");
        customer.reactivateCustomerAccount();
        System.out.println("updateCustomerStorage() called in CustomerController...");
        CustomerStorage.updateCustomerStorage(customer);
    }

    private static void closeCustomerAccount(Customer customer){
        System.out.println("closeCustomerAccount() called in CustomerController...");
        customer.closeCustomerAccount();
        System.out.println("updateCustomerStorage() called in CustomerController...");
        CustomerStorage.updateCustomerStorage(customer);
    }

    private static void removeCustomer(Customer customer){
        if(customer.getCustomerStatus().equals(CustomerStatus.CLOSED)){
            System.out.println("removeCustomer() called in CustomerController...");
            CustomerStorage.removeCustomer(customer);
            IDStorage.addCustomerID(customer.getId());
        }
    }

}
