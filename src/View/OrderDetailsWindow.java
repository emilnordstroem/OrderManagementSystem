package View;

import Domain.Models.Order;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class OrderDetailsWindow extends Stage {
    private final Order selectedOrder;
    private final TabPane tabPane = new TabPane();

    // Order information overview
    private final TextField orderIDTextField = new TextField();
    private final TextField orderStatusTextField = new TextField();
    private final TextField orderNetValueTextField = new TextField();
    private final TextField orderDateTextField = new TextField();

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
        orderInfoGridPane.add(orderStatusTextField, 1,1);
        Label netValueLabel = new Label("Net value");
        Label netValueCurrencyLabel = new Label("DKK");
        orderInfoGridPane.add(netValueLabel, 2,0);
        orderInfoGridPane.add(orderNetValueTextField, 3,0);
        orderInfoGridPane.add(netValueCurrencyLabel, 4,0);
        Label placementDateLabel = new Label("Registration date");
        orderInfoGridPane.add(placementDateLabel, 0,2);
        orderInfoGridPane.add(orderDateTextField, 1,2);
        //===========================================
        pane.add(orderInfoGridPane, 0,0);
        pane.add(tabPane, 0,1);
    }

    private void orderElementContents(){
        orderIDTextField.setEditable(false);
        orderIDTextField.setText(selectedOrder.getId());

        orderNetValueTextField.setEditable(false);
        orderNetValueTextField.setText(String.format("%.2f",selectedOrder.getPrice()));

        orderStatusTextField.setEditable(false);
        orderStatusTextField.setText(String.valueOf(selectedOrder.getOrderStatus()));

        orderDateTextField.setEditable(false);
        orderDateTextField.setText(selectedOrder.getPlacementDate().toString());
    }

    private void tabPaneContent(){
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE); // Not possible to close tabs

        Tab tabItemOverview = new Tab("Items");
        tabItemOverview.setContent(new OrderItemOverviewPane(selectedOrder));
        tabPane.getTabs().add(tabItemOverview);

        Tab tabShippingOverview = new Tab("Shipping");
        tabShippingOverview.setContent(new OrderShippingOverviewPane(selectedOrder));
        tabPane.getTabs().add(tabShippingOverview);
    }
}
