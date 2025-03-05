package View.utility.sort;

import Domain.Models.Order;
import Storage.OrderStorage;

import java.util.ArrayList;
import java.util.Comparator;

public class OrderSortAlgorithm {
    //====================================================================
    // Sorted arrayList by OrderID : insertion sort
    public static ArrayList<Order> sortedOrderArrayListByID() {
        ArrayList<Order> orderArrayList = new ArrayList<>(OrderStorage.getORDERS()); // Copy to avoid modifying the original

        if (orderArrayList.isEmpty()) {
            System.out.println("OrderStorage.getORDERS() is empty -> returning empty list");
            return new ArrayList<>(); // Return empty list instead of null
        }

        StopWatch.start();
        orderArrayList.sort(Comparator.comparing(Order::getId)); // Efficient sorting using Java's built-in sort
        StopWatch.stop();

        System.out.println("orderArrayList sorted by id and returned");
        System.out.printf("sortedOrderArrayListByID(): %d milliseconds%n", StopWatch.durationMilliSeconds());

        return orderArrayList;
    }

    //====================================================================
    // Sorted arrayList by Full Name : insertion sort
    public static ArrayList<Order> sortedOrderArrayListByName() {
        ArrayList<Order> orderArrayList = OrderStorage.getORDERS();
        if(!orderArrayList.isEmpty()) {
            StopWatch.start();
            for (int index = 1; index < orderArrayList.size(); index++) {
                String candidateFullName = orderArrayList.get(index).getCustomer().getFullName();
                int previousElement = index - 1;
                String previousFullName = orderArrayList.get(previousElement).getCustomer().getFullName();
                Order tempOrder = orderArrayList.get(index);
                while (previousElement >= 0 && previousFullName.compareTo(candidateFullName) > 0) {
                    orderArrayList.set(previousElement + 1, orderArrayList.get(previousElement));
                    previousElement = previousElement - 1;
                }
                orderArrayList.set(previousElement + 1, tempOrder);
            }
            StopWatch.stop();
            System.out.printf("sortedOrderArrayListByName(): %d miliseconds%n", StopWatch.durationMilliSeconds());
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
            StopWatch.start();
            for (int index = 1; index < orderArrayList.size(); index++) {
                String candidatePhoneNo = orderArrayList.get(index).getCustomer().getPhoneNo();
                int previousElement = index - 1;
                String previousPhoneNo = orderArrayList.get(previousElement).getCustomer().getPhoneNo();
                Order tempOrder = orderArrayList.get(index);
                while (previousElement >= 0 && previousPhoneNo.compareTo(candidatePhoneNo) > 0) {
                    orderArrayList.set(previousElement + 1, orderArrayList.get(previousElement));
                    previousElement = previousElement - 1;
                }
                orderArrayList.set(previousElement + 1, tempOrder);
            }
            System.out.println("orderArrayList sorted by Phone Number and returned");
            StopWatch.stop();
            System.out.printf("sortedOrderArrayListByPhoneNumber(): %d miliseconds%n", StopWatch.durationMilliSeconds());
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
            StopWatch.start();
            for (int index = 1; index < orderArrayList.size(); index++) {
                String candidateEmail = orderArrayList.get(index).getCustomer().getEmail();
                String previousEmail = orderArrayList.get(index - 1).getCustomer().getEmail();
                int previousElement = index - 1;
                Order tempOrder = orderArrayList.get(index);
                while (previousElement >= 0 && previousEmail.compareTo(candidateEmail) > 0) {
                    orderArrayList.set(previousElement + 1, orderArrayList.get(previousElement));
                    previousElement = previousElement - 1;
                }
                orderArrayList.set(previousElement + 1, tempOrder);
            }
            System.out.println("orderArrayList sorted by email and returned");
            StopWatch.stop();
            System.out.printf("sortedOrderArrayListByEmail(): %d miliseconds%n", StopWatch.durationMilliSeconds());
            return orderArrayList;
        }
        System.out.println("OrderStorage.getORDERS() is empty -> returning null");
        return null;
    }
}
