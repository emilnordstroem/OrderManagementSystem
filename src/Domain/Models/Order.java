package Domain.Models;

import Storage.IDStorage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Order {
    private String id;
    private OrderStatus orderStatus;
    private Customer customer;
    private ArrayList<Item> items;
    private double price;
    private LocalDate placementDate;
    private Address deliveryAddress;
    private LocalDate expectedDeliveryDate;
    private String orderNotation;

    public Order(Customer customer, ArrayList<Item> items, Address deliveryAddress) {
        this.id = Long.toString(generateID());
        this.orderStatus = setOrderStatusPlaced();
        this.customer = customer;
        this.items = items;
        this.price = calculateTotalPrice(items);
        this.placementDate = LocalDate.now();
        this.deliveryAddress = deliveryAddress;
        this.expectedDeliveryDate = calculateExpectedDeliveryDate();
        this.orderNotation = "";
    }

    private Long generateID(){
        long id = new Random().nextInt(111_111, 999_999) + 1;
        while(IDStorage.orderIdentificationAlreadyExist(id)){
            id = new Random().nextInt(111_111, 999_999) + 1;
        }
        IDStorage.addOrderId(id);
        return id;
    }

    public String getId() {
        return id;
    }

    public OrderStatus getOrderStatus() {
        return this.orderStatus;
    }

    private double calculateTotalPrice(ArrayList<Item> orderedItems){
        double result = 0;
        for(Item item : orderedItems){
            result += item.getPrice();
        }
        return result;
    }

    public double getPrice() {
        return price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getPlacementDate() {
        return placementDate;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public LocalDate getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    private LocalDate calculateExpectedDeliveryDate(){
        return placementDate.plusDays(3);
    }

    protected OrderStatus setOrderStatusPlaced() {
        return OrderStatus.PLACED;
    }

    public void setOrderStatusCancelled(){
        this.orderStatus = OrderStatus.CANCELLED;
    }

    public void setOrderStatusPacked(){
        this.orderStatus = OrderStatus.PACKED;
    }

    public void setOrderStatusInTransit(){
        this.orderStatus = OrderStatus.INTRANSIT;
    }

    public void setOrderStatusDelivered(){
        this.orderStatus = OrderStatus.DELIVERED;
    }

    public void setOrderStatusReturned(){
        this.orderStatus = OrderStatus.RETURNED;
    }

    public String getOrderNotation() {
        return orderNotation;
    }

    public void setOrderNotation(String orderNotation) {
        this.orderNotation = orderNotation;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(
                String.format("%s (%s)%n",
                id,
                orderStatus
        ));
        for(Item item : items){
            builder.append(String.format("%s%n", item.toString()));
        }
        return builder.toString();
    }
}
