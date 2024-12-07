package View;

import Domain.Models.Item;
import Domain.Models.Order;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class OrderItemOverviewPane extends GridPane {
    private Order selectedOrder;

    // Order content overview
    private final TableView<Item> allItemsTableView = new TableView<>();
    private final TableColumn<Item, String> itemID = new TableColumn<>("id");
    private final TableColumn<Item, String> itemName = new TableColumn<>("status");
    private final TableColumn<Item, String> itemDescription = new TableColumn<>("description");
    private final TableColumn<Item, Double> itemPrice = new TableColumn<>("price");
    private final TableColumn<Item, String> currency = new TableColumn<>("currency");

    public OrderItemOverviewPane(Order order) {
        this.selectedOrder = order;
        setElementLayout();
        setAllItemsTableView();
        this.setGridLinesVisible(true);
    }

    private void setElementLayout(){
        allItemsTableView.setPrefSize(700,250);
        this.add(allItemsTableView,0,2);
    }

    private void setAllItemsTableView(){
        itemID.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getId()));
        itemName.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getName()));
        itemDescription.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDescription()));
        itemPrice.setCellValueFactory(cellDate ->
                new SimpleObjectProperty(String.format("%.2f",cellDate.getValue().getPrice())));
        currency.setCellValueFactory(cellData ->
                new SimpleStringProperty("DKK"));

        ObservableList<Item> orderedItemsObservableList = FXCollections.observableArrayList(selectedOrder.getItems());
        allItemsTableView.setItems(orderedItemsObservableList);
        allItemsTableView.getColumns().addAll(itemID, itemName, itemDescription, itemPrice, currency);
    }
}
