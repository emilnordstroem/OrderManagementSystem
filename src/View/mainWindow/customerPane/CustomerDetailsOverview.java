package View.mainWindow.customerPane;

import Domain.Models.*;
import View.Alert;
import View.utility.StatusComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class CustomerDetailsOverview extends GridPane{
    private final Customer selectedCustomer;
    private final ComboBox<CustomerStatus> customerStatusComboBox = new ComboBox<>();
    private final Button saveButton = new Button("save");
    private final Button editButton = new Button("edit");

    public CustomerDetailsOverview(Customer chosenCustomer) {
        this.selectedCustomer = chosenCustomer;
        setElementContents();
        setButtonAction();
        this.setGridLinesVisible(true);
    }

    private void setElementContents(){
        setElementLayout();
        setCustomerStatusComboBox();
        saveButton.setDisable(true);
    }

    private void setElementLayout(){
        GridPane detailsOverview = new GridPane();
        detailsOverview.setGridLinesVisible(true);
        String[] labelTexts = {"status", "full name", "id", "date of birth", "phone no", "email", "address"};

        detailsOverview.add(new HBox(saveButton, editButton), 0,0);
        this.add(detailsOverview, 0,0);
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
        setElementContents();
    }
}
