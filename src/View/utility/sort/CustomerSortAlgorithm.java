package View.utility.sort;

import Domain.Models.Customer;
import Domain.Models.Order;
import Storage.CustomerStorage;
import java.util.ArrayList;

public class CustomerSortAlgorithm {
    //====================================================================
    // Sorted arrayList by CustomerID : insertion sort
    public static ArrayList<Customer> sortedCustomerArrayListByID() {
        ArrayList<Customer> customerArrayList = CustomerStorage.getCustomers();
        if (!customerArrayList.isEmpty()) {
            StopWatch.start();
            for (int index = 1; index < customerArrayList.size(); index++) {
                Customer candidateCustomer = customerArrayList.get(index);
                int previousElement = index - 1;
                while (previousElement >= 0 && customerArrayList.get(previousElement).getId().compareTo(candidateCustomer.getId()) > 0) {
                    customerArrayList.set(previousElement + 1, customerArrayList.get(previousElement));
                    previousElement = previousElement - 1;
                }
                customerArrayList.set(previousElement + 1, candidateCustomer);
            }
            System.out.println("customerArrayList sorted by id and returned");
            StopWatch.stop();
            System.out.printf("sortedCustomerArrayListByID(): %d milliseconds%n", StopWatch.durationMilliSeconds());
            return customerArrayList;
        }
        System.out.println("CustomerStorage.getCustomers() is empty -> returning null");
        return null;
    }

    //====================================================================
    // Sorted arrayList by CustomerName : insertion sort
    public static ArrayList<Customer> sortedCustomerArrayListByName() {
        ArrayList<Customer> customerArrayList = CustomerStorage.getCustomers();
        if(!customerArrayList.isEmpty()) {
            StopWatch.start();
            for (int index = 1; index < customerArrayList.size(); index++) {
                Customer candidateCustomer = customerArrayList.get(index);
                int previousElement = index - 1;
                while (previousElement >= 0 && customerArrayList.get(previousElement).getFullName().compareTo(candidateCustomer.getFullName()) > 0) {
                    customerArrayList.set(previousElement + 1, customerArrayList.get(previousElement));
                    previousElement = previousElement - 1;
                }
                customerArrayList.set(previousElement + 1, candidateCustomer);
            }
            System.out.println("customerArrayList sorted by id and returned");
            StopWatch.stop();
            System.out.printf("sortedCustomerArrayListByName(): %d miliseconds%n", StopWatch.durationMilliSeconds());
            return customerArrayList;
        }
        System.out.println("CustomerStorage.getCustomers() is empty -> returning null");
        return null;
    }

    //====================================================================
    // Sorted arrayList by CustomerPhoneNo : insertion sort
    public static ArrayList<Customer> sortedCustomerArrayListByPhoneNo() {
        ArrayList<Customer> customerArrayList = CustomerStorage.getCustomers();
        if(!customerArrayList.isEmpty()) {
            StopWatch.start();
            for (int index = 1; index < customerArrayList.size(); index++) {
                Customer candidateCustomer = customerArrayList.get(index);
                int previousElement = index - 1;
                while (previousElement >= 0 && customerArrayList.get(index).getPhoneNo().compareTo(candidateCustomer.getPhoneNo()) > 0) {
                    customerArrayList.set(previousElement + 1, customerArrayList.get(previousElement));
                    previousElement = previousElement - 1;
                }
                customerArrayList.set(previousElement + 1, candidateCustomer);
            }
            System.out.println("customerArrayList sorted by id and returned");
            StopWatch.stop();
            System.out.printf("sortedCustomerArrayListByPhoneNo(): %d miliseconds%n", StopWatch.durationMilliSeconds());
            return customerArrayList;
        }
        System.out.println("CustomerStorage.getCustomers() is empty -> returning null");
        return null;
    }

    //====================================================================
    // Sorted arrayList by CustomerEmail : insertion sort
    public static ArrayList<Customer> sortedCustomerArrayListByEmail() {
        ArrayList<Customer> customerArrayList = CustomerStorage.getCustomers();
        if(!customerArrayList.isEmpty()) {
            StopWatch.start();
            for (int index = 1; index < customerArrayList.size(); index++) {
                Customer candidateCustomer = customerArrayList.get(index);
                int previousElement = index - 1;
                while (previousElement >= 0 && customerArrayList.get(previousElement).getPhoneNo().compareTo(candidateCustomer.getEmail()) > 0) {
                    customerArrayList.set(previousElement + 1, customerArrayList.get(previousElement));
                    previousElement = previousElement - 1;
                }
                customerArrayList.set(previousElement + 1, candidateCustomer);
            }
            System.out.println("customerArrayList sorted by id and returned");
            StopWatch.stop();
            System.out.printf("sortedCustomerArrayListByEmail(): %d miliseconds%n", StopWatch.durationMilliSeconds());
            return customerArrayList;
        }
        System.out.println("CustomerStorage.getCustomers() is empty -> returning null");
        return null;
    }
}