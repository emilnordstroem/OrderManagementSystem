package View.mainWindow.orderPane;

import Domain.Controller.OrderController;
import Domain.Models.Order;
import View.orderDetailsWindow.OrderDetailsWindow;
import View.utility.search.SearchButtonAction;
import View.utility.TableViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class OrderOverviewPane extends GridPane {
    // Input TextFields
    private final TextField orderIDTextField = new TextField();
    private final TextField customerFullNameTextField = new TextField();
    private final TextField customerPhoneNumberTextField = new TextField();
    private final TextField customerEmailTextField = new TextField();
    // Interaction Buttons
    private final Button searchButton = new Button("search");
    private final Button clearButton = new Button("clear");
    // Order table
    private final TableView<Order> orderOverviewTableView;
    private ObservableList<Order> orderObservableList = FXCollections.observableArrayList(OrderController.getOrders());

    public OrderOverviewPane() {
        orderOverviewTableView = TableViewFactory.createOrderTableView(orderObservableList);
        setElementLayout();
        setSearchKeyFunctionality();
        setButtonFunctionality();
        setOrderSelectionFunctionality();
        this.setGridLinesVisible(false);
    }

    private void setElementLayout(){
        GridPane pane = new GridPane();
        pane.setGridLinesVisible(false);
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

//        // Research why there is a dublicated Children error when VBox is not implementet??
//        VBox vBox = new VBox(orderOverviewTableView);
//        this.add(vBox, 0,1);
    }

    private void setSearchKeyFunctionality(){
        this.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    ArrayList<Order> targetOrderArrayList = SearchButtonAction.orderSearch(constructTextFieldArrayList());
                    assert targetOrderArrayList != null;
                    ObservableList<Order> targetOrderObservableList = FXCollections.observableArrayList(targetOrderArrayList);
                    orderOverviewTableView.setItems(targetOrderObservableList);
                    targetOrderArrayList.clear();
                } catch (Exception nullPointerException) {
                    System.out.println("NullPointerException() : Search without input");
                }
            }
        });
    }

    private void setButtonFunctionality(){
        searchButton.setOnAction(event -> {
            try {
                ArrayList<Order> targetOrderArrayList = SearchButtonAction.orderSearch(constructTextFieldArrayList());
                assert targetOrderArrayList != null;
                ObservableList<Order> targetOrderObservableList = FXCollections.observableArrayList(targetOrderArrayList);
                orderOverviewTableView.setItems(targetOrderObservableList);
            } catch (Exception nullPointerException) {
                System.out.println("NullPointerException() : Search without input");
            }
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
        orderOverviewTableView.setRowFactory(event -> {
            TableRow<Order> row = new TableRow<>();
            row.setOnMouseClicked(event1 -> {
                if (event1.getClickCount() == 2 && (! row.isEmpty())) {
                    new OrderDetailsWindow(row.getItem()).showAndWait();
                    orderObservableList.setAll(OrderController.getOrders());
                }
            });
            return row;
        });
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