package Storage;

import Domain.Models.Order;

import java.util.ArrayList;

public class OrderStorage {
    private static final ArrayList<Order> ORDERS = new ArrayList<>();

    //=================================================================
    // Order
    public static void addOrder(Order order){
        if(!ORDERS.contains(order)){
            ORDERS.add(order);
            System.out.printf("%s added to ORDERS in OrderStorage%n", order.getId());
        } else {
            System.out.printf("%s already added to ORDERS in OrderStorage%n", order.getId());
        }
    }

    public static void removeOrder(Order order){
        ORDERS.remove(order);
        System.out.printf("%s removed from ORDERS in OrderStorage%n", order.getId());
    }

    public static void updateOrderStorage(Order updatedOrder){
        for(Order currentOrder : ORDERS){
            if(currentOrder.getId().compareTo(updatedOrder.getId()) == 0){
                ORDERS.remove(currentOrder);
                ORDERS.add(updatedOrder);
                System.out.println("Order replaced - ORDERS updated in OrderStorage");
            }
        }
    }

    public static ArrayList<Order> getORDERS(){
        return new ArrayList<>(ORDERS);
    }
}
