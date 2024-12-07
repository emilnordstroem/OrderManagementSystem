package View;

import Domain.Controller.OrderController;
import Domain.Controller.SearchAlgorithm;
import Domain.Models.Order;
import Domain.Models.OrderStatus;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.time.LocalDate;
import java.util.ArrayList;

public class OverviewPane extends GridPane {
    // Input TextFields
    private final TextField orderIDTextField = new TextField();
    private final TextField customerFullNameTextField = new TextField();
    private final TextField customerPhoneNumberTextField = new TextField();
    private final TextField customerEmailTextField = new TextField();
    // Interaction Buttons
    private final Button searchButton = new Button("search");
    private final Button clearButton = new Button("clear");
    // Order table
    private final TableView<Order> orderOverviewTableView = new TableView<>();
    private final ObservableList<Order> orderObservableList = FXCollections.observableArrayList(OrderController.getOrders());
    private final TableColumn<Order, String> orderId = new TableColumn<>("id");
    private final TableColumn<Order, OrderStatus> orderStatus = new TableColumn<>("status");
    private final TableColumn<Order, String> customerFullName = new TableColumn<>("customer");
    private final TableColumn<Order, String> deliveryAddress = new TableColumn<>("delivery address");
    private final TableColumn<Order, LocalDate> placementDate = new TableColumn<>("placement date");
    private final TableColumn<Order, LocalDate> estimatedDeliveryDate = new TableColumn<>("est. delivery date");

    public OverviewPane() {
        setElementLayout();
        setOrderOverviewTableView();
        setButtonFunctionality();
        setOrderSelectionFunctionality();
        this.setGridLinesVisible(true);
    }

    private void setElementLayout(){
        GridPane pane = new GridPane();
        pane.setGridLinesVisible(true);
        Label orderIDLabel = new Label("order-id");
        Label customerFullNameLabel = new Label("name");
        Label customerPhoneNumberLabel = new Label("phone number");
        Label customerEmailLabel = new Label("email");

        pane.add(orderIDLabel, 0,0);
        pane.add(orderIDTextField, 1,0);
        pane.add(customerFullNameLabel, 0,1);
        pane.add(customerFullNameTextField, 1,1);
        pane.add(customerPhoneNumberLabel, 0,2);
        pane.add(customerPhoneNumberTextField, 1,2);
        pane.add(customerEmailLabel, 0,3);
        pane.add(customerEmailTextField, 1,3);

        HBox buttonHBox = new HBox(searchButton, clearButton);
        pane.add(buttonHBox, 1,4);

        this.add(pane,0,0);
        this.add(orderOverviewTableView,0,1);
        orderOverviewTableView.setPrefWidth(1000);
    }

    private void setOrderOverviewTableView(){

        orderId.setCellValueFactory(new PropertyValueFactory<>("id"));
        orderStatus.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getOrderStatus()));
        customerFullName.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCustomer().getFullName()));
        deliveryAddress.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getDeliveryAddress().toString()));
        placementDate.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getPlacementDate()));
        estimatedDeliveryDate.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getExpectedDeliveryDate()));

        orderOverviewTableView.setItems(orderObservableList);
        orderOverviewTableView.getColumns().addAll(orderId, orderStatus, customerFullName, deliveryAddress, placementDate, estimatedDeliveryDate);

        VBox vbox = new VBox(orderOverviewTableView);

        this.add(vbox, 0,1);
    }

    private void setButtonFunctionality(){
        searchButton.setOnAction(event -> {
            ArrayList<Order> targetOrderArrayList = new ArrayList<>();
            ArrayList<TextField> inputTextFields = constructTextFieldArrayList();

            for(TextField inputTextField : inputTextFields){
                if(!inputTextField.getText().isBlank() && inputTextFields.indexOf(inputTextField) == 0){
                    String orderID = inputTextField.getText();
                    ArrayList<Order> sortedOrderArrayList = SearchAlgorithm.sortedOrderArrayListByID();
                    Order targetOrder = SearchAlgorithm.searchOrderByID(sortedOrderArrayList, orderID);
                    break;
                } else if(!inputTextField.getText().isBlank() && inputTextFields.indexOf(inputTextField) == 1){
                    String fullName = inputTextField.getText();
                    ArrayList<Order> sortedOrderArrayList = SearchAlgorithm.sortedOrderArrayListByFullName();
                    targetOrderArrayList = SearchAlgorithm.searchOrderByFullName(sortedOrderArrayList, fullName);
                    break;
                } else if(!inputTextField.getText().isBlank() && inputTextFields.indexOf(inputTextField) == 2){
                    String phoneNumber = inputTextField.getText();
                    ArrayList<Order> sortedOrderArrayList = SearchAlgorithm.sortedOrderArrayListByPhoneNumber();
                    targetOrderArrayList = SearchAlgorithm.searchOrderByPhoneNumber(sortedOrderArrayList, phoneNumber);
                    break;
                } else if(!inputTextField.getText().isBlank() && inputTextFields.indexOf(inputTextField) == 2){
                    String email = inputTextField.getText();
                    ArrayList<Order> sortedOrderArrayList = SearchAlgorithm.sortedOrderArrayListByEmail();
                    targetOrderArrayList = SearchAlgorithm.searchOrderByEmail(sortedOrderArrayList, email);
                    break;
                }
            }

            ObservableList<Order> targetOrderObservableList = FXCollections.observableArrayList(targetOrderArrayList);
            orderOverviewTableView.setItems(targetOrderObservableList);
            targetOrderArrayList.clear();
        });

        clearButton.setOnAction(event -> {
            System.out.println("clearButton clicked...");
            orderIDTextField.clear();
            customerFullNameTextField.clear();
            customerPhoneNumberTextField.clear();
            customerEmailTextField.clear();
            orderOverviewTableView.setItems(orderObservableList);
        });
    }

    private void setOrderSelectionFunctionality(){

    }

    // Helper method for search
    private ArrayList<TextField> constructTextFieldArrayList(){
        ArrayList<TextField> textFields = new ArrayList<>();
        textFields.add(orderIDTextField);
        textFields.add(customerFullNameTextField);
        textFields.add(customerPhoneNumberTextField);
        textFields.add(customerEmailTextField);
        return textFields;
    }
}
