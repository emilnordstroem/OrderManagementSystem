package View.utility;

import Domain.Models.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;

public class TableViewFactory {
    public static TableView<Order> createOrderTableView(ObservableList<Order> elements) {
        TableView<Order> tableView = new TableView<>();
        tableView.setItems(elements);

        TableColumn<Order, String> orderId = new TableColumn<>("ID");
        orderId.setCellValueFactory(order -> new SimpleStringProperty(order.getValue().getId()));

        TableColumn<Order, OrderStatus> orderStatus = new TableColumn<>("Status");
        orderStatus.setCellValueFactory(order -> new SimpleObjectProperty<>(order.getValue().getOrderStatus()));

        TableColumn<Order, String> customerFullName = new TableColumn<>("Customer");
        customerFullName.setCellValueFactory(order ->
                new SimpleStringProperty(order.getValue().getCustomer().getFullName()));

        TableColumn<Order, String> deliveryAddress = new TableColumn<>("Delivery Address");
        deliveryAddress.setCellValueFactory(order ->
                new SimpleObjectProperty<>(order.getValue().getDeliveryAddress().toString()));

        TableColumn<Order, LocalDate> placementDate = new TableColumn<>("Placement Date");
        placementDate.setCellValueFactory(order ->
                new SimpleObjectProperty<>(order.getValue().getPlacementDate()));

        TableColumn<Order, LocalDate> estimatedDeliveryDate = new TableColumn<>("Est. Delivery Date");
        estimatedDeliveryDate.setCellValueFactory(order ->
                new SimpleObjectProperty<>(order.getValue().getExpectedDeliveryDate()));

        tableView.getColumns().addAll(orderId, orderStatus, customerFullName, deliveryAddress, placementDate, estimatedDeliveryDate);
        return tableView;
    }

    public static TableView<Customer> createCustomerTableView(ObservableList<Customer> elements) {
        TableView<Customer> tableView = new TableView<>();
        tableView.setItems(elements);

        TableColumn<Customer, String> customerId = new TableColumn<>("ID");
        customerId.setCellValueFactory(customer -> new SimpleStringProperty(customer.getValue().getId()));

        TableColumn<Customer, CustomerStatus> customerStatus = new TableColumn<>("Status");
        customerStatus.setCellValueFactory(customer -> new SimpleObjectProperty<>(customer.getValue().getCustomerStatus()));

        TableColumn<Customer, String> customerFullName = new TableColumn<>("Customer");
        customerFullName.setCellValueFactory(customer -> new SimpleStringProperty(customer.getValue().getFullName()));

        tableView.getColumns().addAll(customerId, customerStatus, customerFullName);
        return tableView;
    }

    public static TableView<Item> createItemsTableView(ObservableList<Item> elements){
        TableView<Item> tableView = new TableView<>();
        tableView.setItems(elements);

        TableColumn<Item, String> itemID = new TableColumn<>("id");
        itemID.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getId()));

        TableColumn<Item, String> itemName = new TableColumn<>("status");
        itemName.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getName()));

        TableColumn<Item, String> itemDescription = new TableColumn<>("description");
        itemDescription.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDescription()));

        TableColumn<Item, Double> itemPrice = new TableColumn<>("price");
        itemPrice.setCellValueFactory(cellDate ->
                new SimpleObjectProperty(String.format("%.2f",cellDate.getValue().getPrice())));

        TableColumn<Item, String> currency = new TableColumn<>("currency");
        currency.setCellValueFactory(cellData ->
                new SimpleStringProperty("DKK"));

        tableView.getColumns().addAll(itemID, itemName, itemDescription, itemPrice, currency);
        return tableView;
    }
}
