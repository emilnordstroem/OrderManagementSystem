package View.mainWindow.customerPane;

import Domain.Models.Address;
import Domain.Models.Customer;
import Domain.Models.Order;
import Domain.Models.OrderStatus;
import View.Alert;
import View.utility.search.SearchButtonAction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class CustomerDetailsOverview extends GridPane{
    private Customer chosenCustomer;
    private final ArrayList<Label> customerDetailsLabel = new ArrayList<>();
    private final ArrayList<TextField> customerDetailsTextField = new ArrayList<>();
    private final ListView<Address> customerAddressListViews = new ListView<>();
    private final Button saveButton = new Button("save");
    private final Button editButton = new Button("edit");

    public CustomerDetailsOverview(Customer chosenCustomer) {
        this.chosenCustomer = chosenCustomer;
        setLabelTextFieldArray();
        setElementLayout();
        setElementContents();
        this.setGridLinesVisible(true);
    }

    private void setLabelTextFieldArray(){
        int limit = 7;
        String[] labelText = {"Customer-id", "Status", "Full name", "Date of Birth", "Phone No.", "Email", "Payment info"};
        for(int index = 0; index < limit; index++){
            customerDetailsLabel.add(new Label(labelText[index]));
            customerDetailsTextField.add(new TextField());
        }
    }

    private void setElementLayout(){
        GridPane pane = new GridPane();
        for(int rowIndex = 0; rowIndex < customerDetailsLabel.size(); rowIndex++) {
            VBox labelTextFieldVBox = new VBox(customerDetailsLabel.get(rowIndex), customerDetailsTextField.get(rowIndex));
            pane.add(labelTextFieldVBox, 0, rowIndex);
        }
        customerAddressListViews.setPrefHeight(150);
        pane.add(new VBox(new Label("Address"), customerAddressListViews), 1,0,1, customerDetailsLabel.size());
        pane.add(new HBox(editButton, saveButton), 0, (customerDetailsLabel.size() + 1));
        this.add(pane,0,0);
    }

    private void setElementContents(){
        for(int index = 0; index < customerDetailsTextField.size(); index++){
            customerDetailsTextField.get(index).setEditable(false);
            switch (index){
                case 0:
                    customerDetailsTextField.get(index).setText(chosenCustomer.getId());
                    break;
                case 1:
                    customerDetailsTextField.get(index).setText(chosenCustomer.getCustomerStatus().toString());
                    break;
                case 2:
                    customerDetailsTextField.get(index).setText(chosenCustomer.getFullName());
                    break;
                case 3:
                    customerDetailsTextField.get(index).setText(chosenCustomer.getDateOfBirth().toString());
                    break;
                case 4:
                    customerDetailsTextField.get(index).setText(chosenCustomer.getPhoneNo());
                    break;
                case 5:
                    customerDetailsTextField.get(index).setText(chosenCustomer.getEmail());
                    break;
                case 6:
                    customerDetailsTextField.get(index).setText(chosenCustomer.getPayment().getCensoredCardNumber());
                    break;
                default:
                    break;
            }
        }
        customerAddressListViews.getItems().setAll(chosenCustomer.getAddress());
    }
}
