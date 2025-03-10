package Domain.Controller;

import Domain.Models.*;
import Storage.OrderStorage;
import java.util.ArrayList;

public class OrderController {

    public static Order createOrder(Customer customer, ArrayList<Item> items, Address deliveryAddress){
        System.out.println("createOrder() called in OrderController...");
        Order order = new Order(customer, items, deliveryAddress);
        OrderStorage.addOrder(order);
        customer.addOrder(order);
        return order;
    }

    public static void orderUpdatedCancelled(Order order){
        System.out.println("orderUpdatedCancelled() called in OrderController...");
        if(order.getOrderStatus().equals(OrderStatus.PLACED)){
            System.out.println("setOrderStatusCancelled() called in OrderController...");
            order.setOrderStatusCancelled();
            System.out.println("updateOrderStorage() called in OrderController...");
            OrderStorage.updateOrderStorage(order);
        }
    }

    public static void orderUpdatedPacked(Order order){
        System.out.println("orderUpdatedPacked() called in OrderController...");
        if(!order.getOrderStatus().equals(OrderStatus.CANCELLED)){
            System.out.println("setOrderStatusPacked() called in OrderController...");
            order.setOrderStatusPacked();
            System.out.println("updateOrderStorage() called in OrderController...");
            OrderStorage.updateOrderStorage(order);
        }
    }

    public static void orderUpdatedInTransit(Order order){
        System.out.println("orderUpdatedInTransit() called in OrderController...");
        if(!order.getOrderStatus().equals(OrderStatus.CANCELLED)){
            System.out.println("setOrderStatusInTransit() called in OrderController...");
            order.setOrderStatusInTransit();
            System.out.println("updateOrderStorage() called in OrderController...");
            OrderStorage.updateOrderStorage(order);
        }
    }

    public static void orderUpdatedDelivered(Order order){
        System.out.println("orderUpdatedDelivered() called in OrderController...");
        if(!order.getOrderStatus().equals(OrderStatus.CANCELLED)){
            System.out.println("setOrderStatusDelivered() called in OrderController...");
            order.setOrderStatusDelivered();
            System.out.println("updateOrderStorage() called in OrderController...");
            OrderStorage.updateOrderStorage(order);
        }
    }

    public static void orderUpdatedReturned(Order order){
        System.out.println("orderUpdatedReturned() called in OrderController...");
        if(!order.getOrderStatus().equals(OrderStatus.CANCELLED)){
            System.out.println("setOrderStatusReturned() called in OrderController...");
            order.setOrderStatusReturned();
            System.out.println("updateOrderStorage() called in OrderController...");
            OrderStorage.updateOrderStorage(order);
        }
    }

    public static void orderUpdatedNotation(Order order, String updatedNotation){
        System.out.println("orderUpdatedNotation() called in OrderController...");
        order.setOrderNotation(updatedNotation);
    }

    public static ArrayList<Order> getOrders(){
        return OrderStorage.getORDERS();
    }

    public static String getPaymentCardHolder(Order order){
        return order.getCustomer().getPayment().getCardHolder();
    }

    public static String getPaymentCardNumber(Order order){
        return order.getCustomer().getPayment().getCensoredCardNumber();
    }
}
