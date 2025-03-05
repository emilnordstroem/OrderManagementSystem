package View.mainWindow.customerPane;

import Domain.Controller.CustomerController;
import Domain.Models.*;
import View.Alert;
import View.orderDetailsWindow.OrderDetailsWindow;
import View.utility.StatusComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class CustomerDetailsOverview extends GridPane{
    private final Customer selectedCustomer;
    private final ArrayList<TextField> customerDetailsTextFields = new ArrayList<>();
    private final TextField customerNetSpendingTextField = new TextField();
    private final ComboBox<CustomerStatus> customerStatusComboBox = new ComboBox<>();
    private final ListView<Address> customerAddressListView = new ListView<>();
    private final ListView<Order> customerOrderListView = new ListView<>();
    private final Button saveButton = new Button("save");
    private final Button editButton = new Button("edit");

    public CustomerDetailsOverview(Customer chosenCustomer) {
        this.selectedCustomer = chosenCustomer;
        innerContents();
        setButtonAction();
        setOrderSelectionFunctionality();
        this.setGridLinesVisible(true);
    }

    private void innerContents(){
        setElementLayout();
        setElementContent();
        setCustomerStatusComboBox();
        saveButton.setDisable(true);
    }

    private void setElementLayout(){
        GridPane detailsOverview = new GridPane();
        detailsOverview.setGridLinesVisible(true);
        String[] labelTexts = {"status", "full name", "id", "date of birth", "phone no", "email", "address"};
        for (int index = 0; index < labelTexts.length; index++) {
            Label label = new Label(labelTexts[index]);
            VBox labelTextFieldVBox = new VBox();
            if (index == 0) {
                labelTextFieldVBox.getChildren().addAll(label, customerStatusComboBox);
            } else if (index == labelTexts.length - 1) {
                customerAddressListView.setPrefHeight(150);
                labelTextFieldVBox.getChildren().addAll(label, customerAddressListView);
            } else {
                TextField textField = new TextField();
                customerDetailsTextFields.add(textField);
                labelTextFieldVBox.getChildren().addAll(label, textField);
            }
            detailsOverview.add(labelTextFieldVBox, 0, index);
        }
        detailsOverview.add(new HBox(saveButton, editButton), 0, labelTexts.length);
        detailsOverview.add(new VBox(new Label("orders"), customerOrderListView), 1,1, 2,10);
        detailsOverview.add(new VBox(new Label("net spending"), customerNetSpendingTextField), 1, 0);

        this.add(detailsOverview, 0, 0);
    }

    private void setElementContent(){
        for(int index = 0; index < 6; index++){
            if (customerDetailsTextFields.size() >= 5) {
                customerDetailsTextFields.get(0).setText(selectedCustomer.getFullName());
                customerDetailsTextFields.get(1).setText(selectedCustomer.getId());
                customerDetailsTextFields.get(2).setText(selectedCustomer.getDateOfBirth().toString());
                customerDetailsTextFields.get(3).setText(selectedCustomer.getPhoneNo());
                customerDetailsTextFields.get(4).setText(selectedCustomer.getEmail());
            }
            customerAddressListView.getItems().clear();
            customerAddressListView.getItems().addAll(selectedCustomer.getAddress());
            customerOrderListView.getItems().clear();
            customerOrderListView.getItems().addAll(selectedCustomer.getOrders());
        }
        customerNetSpendingTextField.setText(String.format("%.2f DKK", CustomerController.getTotalSpending(selectedCustomer)));
        customerNetSpendingTextField.setEditable(false);
        customerStatusComboBox.setValue(selectedCustomer.getCustomerStatus());
        customerStatusComboBox.setDisable(true);
        for(TextField textField : customerDetailsTextFields){
            textField.setEditable(false);
        }
    }

    private void setButtonAction(){
        editButton.setOnAction(event -> {
            if(!selectedCustomer.getCustomerStatus().equals(CustomerStatus.CLOSED)){
                customerStatusComboBox.setDisable(false);
                setCustomerStatusComboBox();
            }
            saveButton.setDisable(false);
        });

        saveButton.setOnAction(event -> {
            View.Alert confirmAlert = new Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION, "Confirm changes", "Changes may disable future changes to the customer");
            confirmAlert.showAndWait().ifPresent(response -> {
                if(response == ButtonType.OK){
                    System.out.println("User confirmed changes");
                    determineChanges();
                    saveChangesToOrder();
                    updateOrderInformation();
                } else {
                    System.out.println("User didn't confirm changes");
                }
            });
        });
    }

    private void setCustomerStatusComboBox(){
        ArrayList<CustomerStatus> availableCustomerStatuses = StatusComboBox.setCustomerStatusComboBox(selectedCustomer);
        ObservableList<CustomerStatus> availableOrderStatusesObservableList = FXCollections.observableList(availableCustomerStatuses);
        customerStatusComboBox.setItems(availableOrderStatusesObservableList);
    }

    private void determineChanges(){
        StatusComboBox.customerStatusChanges(selectedCustomer, customerStatusComboBox.getValue());
    }

    private void saveChangesToOrder(){
        System.out.println("Changes saved to the order");
        customerStatusComboBox.setDisable(true);
        customerStatusComboBox.setValue(selectedCustomer.getCustomerStatus());
    }

    private void updateOrderInformation(){
        System.out.println("updateOrderInformation called");
        innerContents();
    }

    private void setOrderSelectionFunctionality(){
        customerOrderListView.setOnMouseClicked(event -> {
            Order order = customerOrderListView.getSelectionModel().getSelectedItem();
            if (event.getClickCount() == 2 && order != null) {
                new OrderDetailsWindow(order).showAndWait();
                customerOrderListView.getItems().setAll(selectedCustomer.getOrders());
            }
        });
    }
}
