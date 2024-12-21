package View.orderDetailsWindow;

import Domain.Controller.OrderController;
import Domain.Models.Order;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class OrderPaymentPane extends GridPane {
    private Order selectedOrder;

    private final TextField cardHolderTextField = new TextField();
    private final TextField cardNumberTextField = new TextField();

    public OrderPaymentPane(Order order) {
        this.selectedOrder = order;
        setElementLayout();
        setAllItemsTableView();
        this.setGridLinesVisible(false);
    }

    private void setElementLayout(){
        GridPane paymentInformationPane = new GridPane();
        Label paymentInformationLabel = new Label("Payment information");
        paymentInformationPane.add(paymentInformationLabel, 0,0);
        Label cardHolderLabel = new Label("Card holder");
        paymentInformationPane.add(cardHolderLabel, 0,1);
        paymentInformationPane.add(cardHolderTextField, 1,1);
        Label cardNumberLabel = new Label("Card number");
        paymentInformationPane.add(cardNumberLabel, 0,2);
        paymentInformationPane.add(cardNumberTextField, 1,2);
        this.add(paymentInformationPane, 0,0);
    }

    private void setAllItemsTableView(){
        cardHolderTextField.setText(OrderController.getPaymentCardHolder(selectedOrder));
        cardHolderTextField.setEditable(false);
        cardNumberTextField.setText(OrderController.getPaymentCardNumber(selectedOrder));
        cardNumberTextField.setEditable(false);
    }
}
