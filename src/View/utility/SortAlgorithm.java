package View.utility;

import Domain.Models.Order;
import Storage.OrderStorage;

import java.util.ArrayList;

public class SortAlgorithm {
    //====================================================================
    // Sorted arrayList by OrderID : bubble sort
    public static ArrayList<Order> sortedOrderArrayListByID() {
        ArrayList<Order> orderArrayList = OrderStorage.getORDERS();
        if(!orderArrayList.isEmpty()) {
            for (int outerIndex = 0; outerIndex < orderArrayList.size() - 1; outerIndex++) {
                for (int innerIndex = 0; innerIndex < orderArrayList.size() - outerIndex - 1; innerIndex++) {
                    String currentOrderID = orderArrayList.get(innerIndex).getId();
                    String nextOrderID = orderArrayList.get(innerIndex + 1).getId();
                    if(currentOrderID.compareTo(nextOrderID) > 0) {
                        Order temp = orderArrayList.get(innerIndex);
                        orderArrayList.set(innerIndex, orderArrayList.get(innerIndex + 1));
                        orderArrayList.set(innerIndex + 1, temp);
                    }
                }
            }
            System.out.println("orderArrayList sorted by id and returned");
            return orderArrayList;
        }
        System.out.println("OrderStorage.getORDERS() is empty -> returning null");
        return null;
    }

    //====================================================================
    // Sorted arrayList by Full Name : bubble sort
    public static ArrayList<Order> sortedOrderArrayListByName() {
        ArrayList<Order> orderArrayList = OrderStorage.getORDERS();
        if(!orderArrayList.isEmpty()) {
            for (int outerIndex = 0; outerIndex < orderArrayList.size() - 1; outerIndex++) {
                for (int innerIndex = 0; innerIndex < orderArrayList.size() - outerIndex - 1; innerIndex++) {
                    String currentFullName = orderArrayList.get(innerIndex).getCustomer().getFullName();
                    String nextFullName = orderArrayList.get(innerIndex + 1).getCustomer().getFullName();
                    if(currentFullName.compareTo(nextFullName) > 0) {
                        Order temp = orderArrayList.get(innerIndex);
                        orderArrayList.set(innerIndex, orderArrayList.get(innerIndex + 1));
                        orderArrayList.set(innerIndex + 1, temp);
                    }
                }
            }
            System.out.println("orderArrayList sorted by full name and returned");
            return orderArrayList;
        }
        System.out.println("OrderStorage.getORDERS() is empty -> returning null");
        return null;
    }

    //====================================================================
    // Sorted arrayList by Phone number : bubble sort
    public static ArrayList<Order> sortedOrderArrayListByPhoneNumber() {
        ArrayList<Order> orderArrayList = OrderStorage.getORDERS();
        if(!orderArrayList.isEmpty()) {
            for (int outerIndex = 0; outerIndex < orderArrayList.size() - 1; outerIndex++) {
                for (int innerIndex = 0; innerIndex < orderArrayList.size() - outerIndex - 1; innerIndex++) {
                    String currentPhoneNumber = orderArrayList.get(innerIndex).getCustomer().getPhoneNo();
                    String nextPhoneNumber = orderArrayList.get(innerIndex + 1).getCustomer().getPhoneNo();
                    if(currentPhoneNumber.compareTo(nextPhoneNumber) > 0) {
                        Order temp = orderArrayList.get(innerIndex);
                        orderArrayList.set(innerIndex, orderArrayList.get(innerIndex + 1));
                        orderArrayList.set(innerIndex + 1, temp);
                    }
                }
            }
            System.out.println("orderArrayList sorted by Phone Number and returned");
            return orderArrayList;
        }
        System.out.println("OrderStorage.getORDERS() is empty -> returning null");
        return null;
    }

    //====================================================================
    // Sorted arrayList by Email : bubble sort
    public static ArrayList<Order> sortedOrderArrayListByEmail() {
        ArrayList<Order> orderArrayList = OrderStorage.getORDERS();
        if(!orderArrayList.isEmpty()) {
            for (int outerIndex = 0; outerIndex < orderArrayList.size() - 1; outerIndex++) {
                for (int innerIndex = 0; innerIndex < orderArrayList.size() - outerIndex - 1; innerIndex++) {
                    String currentEmail = orderArrayList.get(innerIndex).getCustomer().getEmail();
                    String nextFirstEmail = orderArrayList.get(innerIndex + 1).getCustomer().getEmail();
                    if(currentEmail.compareTo(nextFirstEmail) > 0) {
                        Order temp = orderArrayList.get(innerIndex);
                        orderArrayList.set(innerIndex, orderArrayList.get(innerIndex + 1));
                        orderArrayList.set(innerIndex + 1, temp);
                    }
                }
            }
            System.out.println("orderArrayList sorted by Email and returned");
            return orderArrayList;
        }
        System.out.println("OrderStorage.getORDERS() is empty -> returning null");
        return null;
    }
}
