package Domain.Controller;

import Domain.Models.*;
import Storage.CustomerStorage;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class BackEndFunctionalityTest {
    public static void main(String[] args) {
        //==============================================================
        Address address = new Address("streetName", "buildingNo", "postalCode", "city", "country");
        Payment creditCard = new Payment("First Name", "123456789");
        Customer testCustomer = CustomerController.createCustomer("First", "LastName", LocalDate.of(2002, 12,13), address, creditCard);
        //==============================================================
        System.out.println("//==============================================================");
        System.out.println(testCustomer.getCustomerStatus());
        CustomerController.inactiveCustomerAccount(testCustomer);
        System.out.println(testCustomer.getCustomerStatus());
        CustomerController.reactivateCustomerAccount(testCustomer);
        System.out.println(testCustomer.getCustomerStatus());
        //==============================================================
        System.out.println("//==============================================================");
        ArrayList<Customer> storageCustomers = CustomerStorage.getCustomers();
        for(Customer customer : storageCustomers){
            if(customer.getCustomerStatus().equals(CustomerStatus.ACTIVE)){
                System.out.println(customer);
            }
        }
        //==============================================================
        Item testItem1 = ItemController.createItem("name", "description", 1000);
        Item testItem2 = ItemController.createItem("name", "description", 1000);
        //==============================================================
        ArrayList<Item> orderedItems = new ArrayList<>();
        orderedItems.add(testItem1);
        orderedItems.add(testItem2);
        Order testOrder = OrderController.createOrder(testCustomer, orderedItems, testCustomer.getAddress());
        System.out.println(testOrder.getPrice());
        System.out.println(CustomerController.getTotalSpending(testCustomer));
        //==============================================================
        System.out.println("//==============================================================");
        System.out.println(testOrder.getOrderStatus());
        OrderController.orderUpdatedCancelled(testOrder);
        System.out.println(testOrder.getOrderStatus());
        OrderController.orderUpdatedDelivered(testOrder);
        System.out.println(testOrder.getOrderStatus());

    }
}
