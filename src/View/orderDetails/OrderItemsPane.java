package View.orderDetails;

import Domain.Models.Item;
import Domain.Models.Order;
import View.utility.TableViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class OrderItemsPane extends GridPane {
    // Order content overview
    private final TableView<Item> allItemsTableView;

    public OrderItemsPane(Order order) {
        ObservableList<Item> orderedItemsObservableList = FXCollections.observableArrayList(order.getItems());
        allItemsTableView = TableViewFactory.createItemsTableView(orderedItemsObservableList);
        setElementLayout();
        this.setGridLinesVisible(false);
    }

    private void setElementLayout(){
        allItemsTableView.setPrefSize(700,250);
        this.add(allItemsTableView,0,2);
    }
}
