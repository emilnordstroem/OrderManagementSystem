package Domain.Controller;

import Domain.Models.Order;
import Storage.OrderStorage;

import java.util.ArrayList;

public class SearchAlgorithm {
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
    // Binary Search Algorithm: OrderID
    public static ArrayList<Order> searchOrderByID(ArrayList<Order> sortedOrderArrayList, String target){
        ArrayList<Order> resultArrayList = new ArrayList<>();
        int left = 0;
        int right = sortedOrderArrayList.size();
        while(left <= right){
            int middle = (left + right) / 2;
            Order candidateOrder = sortedOrderArrayList.get(middle);
            if(candidateOrder.getId().compareTo(target) == 0){
                System.out.println("Target found");
                resultArrayList.add(candidateOrder);
                break;
            } else if (candidateOrder.getId().compareTo(target) > 0){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        System.out.println("searchOrderByID() returned null");
        return resultArrayList;
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
    // Binary Search Algorithm: By name (diversed to searchByFullName + searchByFirstName)
    public static ArrayList<Order> searchOrderByName(ArrayList<Order> sortedOrderArrayList, String target){
        ArrayList<Order> resultArrayList;
        if(target.contains(" ")){
            resultArrayList = searchByFullName(sortedOrderArrayList, target);
        } else {
            resultArrayList = searchByFirstName(sortedOrderArrayList, target);
        }

        System.out.println("searchOrderByName() returned");
        for(Order order : resultArrayList){
            System.out.println(order.getCustomer().getFullName());
        }
        return resultArrayList;
    }

    // Method for fullNameSearch
    private static ArrayList<Order> searchByFullName(ArrayList<Order> sortedOrderArrayList, String target){
        ArrayList<Order> resultArrayList = new ArrayList<>();
        int left = 0;
        int right = sortedOrderArrayList.size();

        while(left <= right){
            int middle = (left + right) / 2;
            Order candidateOrder = sortedOrderArrayList.get(middle);
            String candidateFullName = candidateOrder.getCustomer().getFullName();
            if(candidateFullName.compareTo(target) == 0){
                System.out.println("Target found and added to list...");
                resultArrayList.add(candidateOrder);
                for(int index = middle + 1; index < right; index++){
                    System.out.print("Searching further to the right...");
                    candidateOrder = sortedOrderArrayList.get(index);
                    candidateFullName = candidateOrder.getCustomer().getFullName();
                    if(candidateFullName.compareTo(target) == 0){
                        System.out.println("Order added to list");
                        resultArrayList.add(candidateOrder);
                    }
                }
                for(int index = middle - 1; index > left; index--){
                    System.out.print("Searching further to the left...");
                    candidateOrder = sortedOrderArrayList.get(index);
                    candidateFullName = candidateOrder.getCustomer().getFullName();
                    if(candidateFullName.compareTo(target) == 0){
                        System.out.println("Order added to list");
                        resultArrayList.add(candidateOrder);
                    }
                }
                break;
            } else if (candidateFullName.compareTo(target) > 0){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        System.out.println("searchByFullName() returned");
        return resultArrayList;
    }
    // Method for search by First name
    private static ArrayList<Order> searchByFirstName(ArrayList<Order> sortedOrderArrayList, String target){
        ArrayList<Order> resultArrayList = new ArrayList<>();
        int left = 0;
        int right = sortedOrderArrayList.size();

        while(left <= right){
            int middle = (left + right) / 2;
            Order candidateOrder = sortedOrderArrayList.get(middle);
            String candidateFirstName = candidateOrder.getCustomer().getFirstName();
            if(candidateFirstName.compareTo(target) == 0){
                System.out.println("Target found and added to list...");
                resultArrayList.add(candidateOrder);
                for(int index = middle + 1; index < right; index++){
                    System.out.print("Searching further to the right...");
                    candidateOrder = sortedOrderArrayList.get(index);
                    candidateFirstName = candidateOrder.getCustomer().getFirstName();
                    if(candidateFirstName.compareTo(target) == 0){
                        System.out.println("Order added to list");
                        resultArrayList.add(candidateOrder);
                    }
                }
                for(int index = middle - 1; index > left; index--){
                    System.out.print("Searching further to the left...");
                    candidateOrder = sortedOrderArrayList.get(index);
                    candidateFirstName = candidateOrder.getCustomer().getFirstName();
                    if(candidateFirstName.compareTo(target) == 0){
                        System.out.println("Order added to list");
                        resultArrayList.add(candidateOrder);
                    }
                }
                break;
            } else if (candidateFirstName.compareTo(target) > 0){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        System.out.println("searchByFirstName() returned");
        return resultArrayList;
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
    // Binary Search Algorithm: Phone Number
    public static ArrayList<Order> searchOrderByPhoneNumber(ArrayList<Order> sortedOrderArrayList, String target){
        ArrayList<Order> resultArrayList = new ArrayList<>();
        int left = 0;
        int right = sortedOrderArrayList.size();
        while(left <= right){
            int middle = (left + right) / 2;
            Order candidateOrder = sortedOrderArrayList.get(middle);
            String candidatePhoneNumber = candidateOrder.getCustomer().getPhoneNo();
            if(candidatePhoneNumber.compareTo(target) == 0){
                System.out.println("Target found and added to list...");
                resultArrayList.add(candidateOrder);
                for(int index = middle + 1; index < right; index++){
                    System.out.print("Searching further to the right...");
                    // Reassignment of ordre/string variables
                    candidateOrder = sortedOrderArrayList.get(index);
                    candidatePhoneNumber = candidateOrder.getCustomer().getPhoneNo();
                    if(candidatePhoneNumber.compareTo(target) == 0){
                        System.out.println("Order added to list");
                        resultArrayList.add(candidateOrder);
                    }
                }
                for(int index = middle - 1; index > left; index--){
                    System.out.print("Searching further to the left...");
                    candidateOrder = sortedOrderArrayList.get(index);
                    candidatePhoneNumber = candidateOrder.getCustomer().getFullName();
                    if(candidatePhoneNumber.compareTo(target) == 0){
                        System.out.println("Order added to list");
                        resultArrayList.add(candidateOrder);
                    }
                }
                break;
            } else if (candidatePhoneNumber.compareTo(target) > 0){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        System.out.println("searchOrderByPhoneNumber() returned");
        for(Order order : resultArrayList){
            System.out.println(order.getCustomer().getPhoneNo());
        }
        return resultArrayList;
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
    // Binary Search Algorithm: Email
    public static ArrayList<Order> searchOrderByEmail(ArrayList<Order> sortedOrderArrayList, String target){
        ArrayList<Order> resultArrayList = new ArrayList<>();
        int left = 0;
        int right = sortedOrderArrayList.size();
        while(left <= right){
            int middle = (left + right) / 2;
            Order candidateOrder = sortedOrderArrayList.get(middle);
            String candidateEmail = candidateOrder.getCustomer().getEmail();
            if(candidateEmail.compareTo(target) == 0){
                System.out.println("Target found and added to list...");
                resultArrayList.add(candidateOrder);
                for(int index = middle + 1; index < right; index++){
                    System.out.print("Searching further to the right...");
                    // Reassignment of ordre/string variables
                    candidateOrder = sortedOrderArrayList.get(index);
                    candidateEmail = candidateOrder.getCustomer().getEmail();
                    if(candidateEmail.compareTo(target) == 0){
                        System.out.println("Order added to list");
                        resultArrayList.add(candidateOrder);
                    }
                }
                for(int index = middle - 1; index > left; index--){
                    System.out.print("Searching further to the left...");
                    candidateOrder = sortedOrderArrayList.get(index);
                    candidateEmail = candidateOrder.getCustomer().getFullName();
                    if(candidateEmail.compareTo(target) == 0){
                        System.out.println("Order added to list");
                        resultArrayList.add(candidateOrder);
                    }
                }
                break;
            } else if (candidateEmail.compareTo(target) > 0){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        System.out.println("searchOrderByEmail() returned");
        for(Order order : resultArrayList){
            System.out.println(order.getCustomer().getPhoneNo());
        }
        return resultArrayList;
    }
}
