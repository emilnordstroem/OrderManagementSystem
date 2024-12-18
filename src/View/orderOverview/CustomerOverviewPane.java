package View.orderOverview;

import Domain.Controller.CustomerController;
import Domain.Models.Customer;
import View.utility.search.SearchButtonAction;
import View.utility.TableViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class CustomerOverviewPane extends GridPane {
    // Input TextFields
    private final TextField customerIDTextField = new TextField();
    private final TextField customerFullNameTextField = new TextField();
    private final TextField customerPhoneNumberTextField = new TextField();
    private final TextField customerEmailTextField = new TextField();
    // Interaction Buttons
    private final Button searchButton = new Button("search");
    private final Button clearButton = new Button("clear");
    // Order table
    private TableView<Customer> customerOverviewTableView;
    private final ObservableList<Customer> customerObservableList = FXCollections.observableArrayList(CustomerController.getCustomers());

    public CustomerOverviewPane(){
        customerOverviewTableView = TableViewFactory.createCustomerTableView(customerObservableList);
        setElementLayout();
        setButtonFunctionality();
        this.setGridLinesVisible(true);
    }

    private void setElementLayout(){
        GridPane inputGridPane = new GridPane();
        inputGridPane.setGridLinesVisible(false);
        Label customerIDLabel = new Label("customer-id");
        Label customerFullNameLabel = new Label("name");
        Label customerPhoneNumberLabel = new Label("phone number");
        Label customerEmailLabel = new Label("email");

        inputGridPane.add(customerIDLabel, 0,0);
        inputGridPane.add(customerIDTextField, 1,0);
        inputGridPane.add(customerFullNameLabel, 0,1);
        inputGridPane.add(customerFullNameTextField, 1,1);
        inputGridPane.add(customerPhoneNumberLabel, 0,2);
        inputGridPane.add(customerPhoneNumberTextField, 1,2);
        inputGridPane.add(customerEmailLabel, 0,3);
        inputGridPane.add(customerEmailTextField, 1,3);

        HBox buttonHBox = new HBox(searchButton, clearButton);
        inputGridPane.add(buttonHBox, 1,4);
        this.add(inputGridPane,0,0);

        // Research why there is a dublicated Children error when VBox is not implementet??
        VBox vBox = new VBox(customerOverviewTableView);
        this.add(vBox, 0,1);
    }

    private void setButtonFunctionality(){
        searchButton.setOnAction(event -> {
            try {
                ArrayList<Customer> targetCustomer = SearchButtonAction.searchCustomer(constructTextFieldArrayList());
                ObservableList<Customer> targetOrderObservableList = FXCollections.observableArrayList(targetCustomer);
                customerOverviewTableView.setItems(targetOrderObservableList);
            } catch (Exception nullPointerException) {
                System.out.println("NullPointerException() : Search without input");
            }
        });

        clearButton.setOnAction(event -> {
            System.out.println("clearButton clicked...");
            customerIDTextField.clear();
            customerFullNameTextField.clear();
            customerPhoneNumberTextField.clear();
            customerEmailTextField.clear();
            customerOverviewTableView.setItems(customerObservableList);
        });
    }

    // Helper method for search
    private ArrayList<TextField> constructTextFieldArrayList(){
        ArrayList<TextField> textFields = new ArrayList<>();
        textFields.add(customerIDTextField);
        textFields.add(customerFullNameTextField);
        textFields.add(customerPhoneNumberTextField);
        textFields.add(customerEmailTextField);
        return textFields;
    }
}