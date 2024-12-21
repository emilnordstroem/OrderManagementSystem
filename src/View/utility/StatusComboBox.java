package View.utility;

import Domain.Controller.CustomerController;
import Domain.Controller.OrderController;
import Domain.Models.Customer;
import Domain.Models.CustomerStatus;
import Domain.Models.Order;
import Domain.Models.OrderStatus;

import java.util.ArrayList;

public class StatusComboBox {

    public static ArrayList<OrderStatus> setOrderStatusComboBox(Order order){
        ArrayList<OrderStatus> availableOrderStatuses = new ArrayList<>();
        switch (order.getOrderStatus()){
            case PLACED:
                availableOrderStatuses.add(OrderStatus.PACKED);
                availableOrderStatuses.add(OrderStatus.CANCELLED);
                break;
            case PACKED:
                availableOrderStatuses.add(OrderStatus.INTRANSIT);
                break;
            case INTRANSIT:
                availableOrderStatuses.add(OrderStatus.DELIVERED);
                break;
            case DELIVERED:
                availableOrderStatuses.add(OrderStatus.RETURNED);
                break;
        }
        return availableOrderStatuses;
    }

    public static void orderStatusChanges(Order order, OrderStatus orderStatus){
        switch (orderStatus) {
            case PACKED:
                OrderController.orderUpdatedPacked(order);
                break;
            case INTRANSIT:
                OrderController.orderUpdatedInTransit(order);
                break;
            case DELIVERED:
                OrderController.orderUpdatedDelivered(order);
                break;
            case CANCELLED:
                OrderController.orderUpdatedCancelled(order);
                break;
            case RETURNED:
                OrderController.orderUpdatedReturned(order);
                break;
            default:
                System.out.println("Invalid OrderStatus");
                break;
        }
    }

    public static ArrayList<CustomerStatus> setCustomerStatusComboBox(Customer customer){
        ArrayList<CustomerStatus> availableCustomerStatuses = new ArrayList<>();
        switch (customer.getCustomerStatus()){
            case ACTIVE:
                availableCustomerStatuses.add(CustomerStatus.INACTIVE);
                break;
            case INACTIVE:
                availableCustomerStatuses.add(CustomerStatus.ACTIVE);
                availableCustomerStatuses.add(CustomerStatus.CLOSED);
                break;
            case CLOSED:
                availableCustomerStatuses.add(CustomerStatus.CLOSED);
                break;
        }
        return availableCustomerStatuses;
    }

    public static void customerStatusChanges(Customer customer, CustomerStatus customerStatus){
        switch (customerStatus) {
            case ACTIVE:
                CustomerController.reactivateCustomerAccount(customer);
                break;
            case INACTIVE:
                CustomerController.inactiveCustomerAccount(customer);
                break;
            case CLOSED:
                CustomerController.closeCustomerAccount(customer);
                break;
            default:
                System.out.println("Invalid OrderStatus");
                break;
        }
    }
}
