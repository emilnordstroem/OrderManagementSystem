package View.orderDetails;

import Domain.Controller.OrderController;
import Domain.Models.Order;
import Domain.Models.OrderStatus;
import View.Alert;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

public class OrderDetailsWindow extends Stage {
    private final Order selectedOrder;
    private final TabPane tabPane = new TabPane();

    // Order information overview
    private final TextField orderIDTextField = new TextField();
    private final ComboBox<OrderStatus> orderStatusComboBox = new ComboBox<>();
    private final TextField orderNetValueTextField = new TextField();
    private final TextField orderDateTextField = new TextField();
    private final TextArea orderNotationTextArea = new TextArea();

    private final Button closeButton = new Button("close");
    private final Button saveButton = new Button("save");
    private final Button editButton = new Button("edit");

    public OrderDetailsWindow(Order order){
        this.setTitle("Order Details");
        GridPane pane = new GridPane();
        this.selectedOrder = order;
        innerContent(pane);
        this.setScene(new Scene(pane));
    }

    private void innerContent(GridPane pane){
        elementLayout(pane);
        orderElementContents();
        tabPaneContent();
        buttonFunctionalty();
        pane.setGridLinesVisible(true);
    }

    private void elementLayout(GridPane pane){
        GridPane orderInfoGridPane = new GridPane();
        //===========================================
        Label orderIDLabel = new Label("Order ID");
        orderInfoGridPane.add(orderIDLabel, 0,0);
        orderInfoGridPane.add(orderIDTextField, 1,0);

        Label statusLabel = new Label("Status");
        orderInfoGridPane.add(statusLabel, 0,1);
        orderInfoGridPane.add(orderStatusComboBox, 1,1);

        Label netValueLabel = new Label("Net value");
        Label netValueCurrencyLabel = new Label("DKK");
        orderInfoGridPane.add(netValueLabel, 2,0);
        orderInfoGridPane.add(orderNetValueTextField, 3,0);
        orderInfoGridPane.add(netValueCurrencyLabel, 4,0);

        Label placementDateLabel = new Label("Registration date");
        orderInfoGridPane.add(placementDateLabel, 0,2);
        orderInfoGridPane.add(orderDateTextField, 1,2);
        //===========================================
        GridPane descriptionGridPane = new GridPane();
        Label orderNotationLabel = new Label("Description");
        descriptionGridPane.add(orderNotationLabel, 0,0);
        descriptionGridPane.add(orderNotationTextArea, 0,1);
        orderNotationTextArea.setPrefSize(150,70);
        //===========================================
        pane.add(orderInfoGridPane, 0,0);
        pane.add(descriptionGridPane,1,0);
        pane.add(tabPane, 0,1,2,1);
        HBox buttonHBox = new HBox(closeButton, saveButton, editButton);
        pane.add(buttonHBox,0,2);
    }

    private void orderElementContents(){
        orderIDTextField.setEditable(false);
        orderIDTextField.setText(selectedOrder.getId());

        orderNetValueTextField.setEditable(false);
        orderNetValueTextField.setText(String.format("%.2f",selectedOrder.getPrice()));

        orderStatusComboBox.setDisable(true);
        orderStatusComboBox.setValue(selectedOrder.getOrderStatus());
        orderStatusComboBox.setStyle("-fx-opacity: 1.0;" + "-fx-background-color: #f0f0f0;" + "-fx-text-fill: #000000;");

        orderDateTextField.setEditable(false);
        orderDateTextField.setText(selectedOrder.getPlacementDate().toString());

        saveButton.setDisable(true);

        orderNotationTextArea.setEditable(false);
        orderNotationTextArea.setText(selectedOrder.getOrderNotation());
    }

    private void tabPaneContent(){
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE); // Not possible to close tabs

        Tab tabItemOverview = new Tab("Items");
        tabItemOverview.setContent(new OrderItemsPane(selectedOrder));
        tabPane.getTabs().add(tabItemOverview);

        Tab tabShippingOverview = new Tab("Shipping");
        tabShippingOverview.setContent(new OrderShippingPane(selectedOrder));
        tabPane.getTabs().add(tabShippingOverview);
    }

    private void buttonFunctionalty(){
        closeButton.setOnAction(event -> hide());

        editButton.setOnAction(event -> {
            if(!selectedOrder.getOrderStatus().equals(OrderStatus.CANCELLED)){
                System.out.println("Order has not been cancelled");
                orderStatusComboBox.setDisable(false);
                orderStatusComboBox.setItems(selectedOrder.getOrderStatusArrayList());
            }
            orderNotationTextArea.setEditable(true);
            saveButton.setDisable(false);
        });

        saveButton.setOnAction(event -> {
            Alert confirmAlert = new Alert(AlertType.CONFIRMATION, "Confirm changes", "Changes may disable future changes to the order");
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

    private void determineChanges(){
        String orderNotationChange = orderNotationTextArea.getText();
        OrderController.orderUpdatedNotation(selectedOrder, orderNotationChange);

        OrderStatus status = orderStatusComboBox.getValue();
        switch (status) {
            case PACKED:
                OrderController.orderUpdatedPacked(selectedOrder);
                break;
            case INTRANSIT:
                OrderController.orderUpdatedInTransit(selectedOrder);
                break;
            case DELIVERED:
                OrderController.orderUpdatedDelivered(selectedOrder);
                break;
            case CANCELLED:
                OrderController.orderUpdatedCancelled(selectedOrder);
                break;
            default:
                System.out.println("Invalid OrderStatus");
                break;
        }
    }

    private void saveChangesToOrder(){
        System.out.println("Changes saved to the order");
        orderStatusComboBox.setDisable(true);
        orderStatusComboBox.setValue(selectedOrder.getOrderStatus());
        orderNotationTextArea.setDisable(true);
        orderNotationTextArea.setText(selectedOrder.getOrderNotation());
    }

    private void updateOrderInformation(){
        System.out.println("updateOrderInformation called");
        orderElementContents();
    }
}