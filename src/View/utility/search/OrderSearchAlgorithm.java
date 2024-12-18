package View.utility.search;

import Domain.Models.Order;

import java.util.ArrayList;

public class OrderSearchAlgorithm {
    //====================================================================
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
        System.out.println("searchOrderByID() returned");
        return resultArrayList;
    }

    //====================================================================
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
        int right = sortedOrderArrayList.size() - 1;

        while(left <= right){
            int middle = (left + right) / 2;
            Order candidateOrder = sortedOrderArrayList.get(middle);
            String candidateFullName = candidateOrder.getCustomer().getFullName();

            if(candidateOrder.getCustomer().getFullName().compareTo(target) == 0){
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
        int right = sortedOrderArrayList.size() - 1;

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
                    candidatePhoneNumber = candidateOrder.getCustomer().getPhoneNo();
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
                    candidateEmail = candidateOrder.getCustomer().getEmail();
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
            System.out.println(order.getCustomer().getEmail());
        }
        return resultArrayList;
    }
}
