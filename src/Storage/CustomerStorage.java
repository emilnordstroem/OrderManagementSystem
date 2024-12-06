package Storage;

import Domain.Models.Customer;
import Domain.Models.Item;
import Domain.Models.Order;

import java.util.ArrayList;

public class CustomerStorage {
    private static final ArrayList<Customer> CUSTOMERS = new ArrayList<>();

    //=================================================================
    // Customer
    public static void addCustomer(Customer customer){
        if(!CUSTOMERS.contains(customer)){
            CUSTOMERS.add(customer);
            System.out.println(String.format("%s added to CUSTOMERS in CustomerStorage", customer.getFullName()));
        } else {
            System.out.println(String.format("%s already added to CUSTOMERS in CustomerStorage", customer.getFullName()));
        }
    }

    public static void updateCustomerStorage(Customer updatedCustomer){
        for(Customer currentCustomer : CUSTOMERS){
            if(currentCustomer.getId().compareTo(updatedCustomer.getId()) == 0){
                CUSTOMERS.remove(currentCustomer);
                CUSTOMERS.add(updatedCustomer);
                System.out.println("Customer replaced - CUSTOMERS updated in CustomerStorage");
            }
        }
    }

    public static void removeCustomer(Customer customer){
        CUSTOMERS.remove(customer);
        System.out.println(String.format("%s removed from CUSTOMERS in CustomerStorage", customer.getFullName()));
    }

    public static ArrayList<Customer> getCustomers(){
        return new ArrayList<>(CUSTOMERS);
    }
}
