package View.utility.search;

import Domain.Models.Customer;

import java.util.ArrayList;

public class CustomerSearchAlgorithm {
    //====================================================================
    // Binary Search Algorithm: CustomerID
    public static ArrayList<Customer> searchCustomerByID(ArrayList<Customer> sortedCustomerArrayList, String target) {
        ArrayList<Customer> resultArrayList = new ArrayList<>();
        int left = 0;
        int right = sortedCustomerArrayList.size() - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            Customer candidateCustomer = sortedCustomerArrayList.get(middle);
            if (candidateCustomer.getId().compareTo(target) == 0) {
                System.out.println("Target found");
                resultArrayList.add(candidateCustomer);
                break;
            } else if (candidateCustomer.getId().compareTo(target) > 0) { // Corrected to compare IDs
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        System.out.println("searchCustomerByID() returned");
        return resultArrayList;
    }


    //====================================================================
    // Binary Search Algorithm: By name (diversed to searchByFullName + searchByFirstName)
    public static ArrayList<Customer> searchCustomerByName(ArrayList<Customer> sortedCustomerArrayList, String target){
        ArrayList<Customer> resultArrayList;
        if(target.contains(" ")){
            resultArrayList = searchByFullName(sortedCustomerArrayList, target);
        } else {
            resultArrayList = searchByFirstName(sortedCustomerArrayList, target);
        }

        System.out.println("searchCustomerByName() returned");
        for(Customer customer : resultArrayList){
            System.out.println(customer.getFullName());
        }
        return resultArrayList;
    }
    // Method for fullNameSearch
    private static ArrayList<Customer> searchByFullName(ArrayList<Customer> sortedCustomerArrayList, String target){
        ArrayList<Customer> resultArrayList = new ArrayList<>();
        int left = 0;
        int right = sortedCustomerArrayList.size();

        while(left <= right){
            int middle = (left + right) / 2;
            Customer candidateCustomer = sortedCustomerArrayList.get(middle);
            String candidateFullName = candidateCustomer.getFullName();
            if(candidateFullName.compareTo(target) == 0){
                System.out.println("Target found and added to list...");
                resultArrayList.add(candidateCustomer);
                for(int index = middle + 1; index < right; index++){
                    System.out.print("Searching further to the right...");
                    candidateCustomer = sortedCustomerArrayList.get(index);
                    candidateFullName = candidateCustomer.getFullName();
                    if(candidateFullName.compareTo(target) == 0){
                        System.out.println("Order added to list");
                        resultArrayList.add(candidateCustomer);
                    }
                }
                for(int index = middle - 1; index > left; index--){
                    System.out.print("Searching further to the left...");
                    candidateCustomer = sortedCustomerArrayList.get(index);
                    candidateFullName = candidateCustomer.getFullName();
                    if(candidateFullName.compareTo(target) == 0){
                        System.out.println("Order added to list");
                        resultArrayList.add(candidateCustomer);
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
    private static ArrayList<Customer> searchByFirstName(ArrayList<Customer> sortedOrderArrayList, String target){
        ArrayList<Customer> resultArrayList = new ArrayList<>();
        int left = 0;
        int right = sortedOrderArrayList.size();

        while(left <= right){
            int middle = (left + right) / 2;
            Customer candidateCustomer = sortedOrderArrayList.get(middle);
            String candidateFirstName = candidateCustomer.getFirstName();
            if(candidateFirstName.compareTo(target) == 0){
                System.out.println("Target found and added to list...");
                resultArrayList.add(candidateCustomer);
                for(int index = middle + 1; index < right; index++){
                    System.out.print("Searching further to the right...");
                    candidateCustomer = sortedOrderArrayList.get(index);
                    candidateFirstName = candidateCustomer.getFirstName();
                    if(candidateFirstName.compareTo(target) == 0){
                        System.out.println("Order added to list");
                        resultArrayList.add(candidateCustomer);
                    }
                }
                for(int index = middle - 1; index > left; index--){
                    System.out.print("Searching further to the left...");
                    candidateCustomer = sortedOrderArrayList.get(index);
                    candidateFirstName = candidateCustomer.getFirstName();
                    if(candidateFirstName.compareTo(target) == 0){
                        System.out.println("Order added to list");
                        resultArrayList.add(candidateCustomer);
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
    // Binary Search Algorithm: CustomerPhoneNo
    public static ArrayList<Customer> searchCustomerByPhoneNo(ArrayList<Customer> sortedCustomerArrayList, String target){
        ArrayList<Customer> resultArrayList = new ArrayList<>();
        int left = 0;
        int right = sortedCustomerArrayList.size();
        while(left <= right){
            int middle = (left + right) / 2;
            Customer candidateCustomer = sortedCustomerArrayList.get(middle);
            if(candidateCustomer.getPhoneNo().compareTo(target) == 0){
                System.out.println("Target found");
                resultArrayList.add(candidateCustomer);
                break;
            } else if (candidateCustomer.getPhoneNo().compareTo(target) > 0){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        System.out.println("searchOrderByID() returned");
        return resultArrayList;
    }

    //====================================================================
    // Binary Search Algorithm: CustomerEmail
    public static ArrayList<Customer> searchCustomerByEmail(ArrayList<Customer> sortedCustomerArrayList, String target){
        ArrayList<Customer> resultArrayList = new ArrayList<>();
        int left = 0;
        int right = sortedCustomerArrayList.size();
        while(left <= right){
            int middle = (left + right) / 2;
            Customer candidateCustomer = sortedCustomerArrayList.get(middle);
            if(candidateCustomer.getEmail().compareTo(target) == 0){
                System.out.println("Target found");
                resultArrayList.add(candidateCustomer);
                break;
            } else if (candidateCustomer.getEmail().compareTo(target) > 0){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        System.out.println("searchOrderByID() returned");
        return resultArrayList;
    }

}
