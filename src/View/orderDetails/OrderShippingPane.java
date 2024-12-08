package View.orderDetails;

import Domain.Models.Order;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class OrderShippingPane extends GridPane {
    private final Order selectedOrder;

    // Shipping information overview
    private final TextField orderCustomerFullName = new TextField();
    private final TextField orderCustomerPhoneNumber = new TextField();
    private final TextField orderCustomerEmail = new TextField();
    private final TextField orderDeliveryAdresse = new TextField();
    private final TextField orderDeliveryPostalCode = new TextField();
    private final TextField orderDeliveryCity = new TextField();
    private final TextField orderDeliveryCountry = new TextField();

    public OrderShippingPane(Order order) {
        this.selectedOrder = order;
        innerContent();
        this.setGridLinesVisible(true);
    }

    private void innerContent(){
        elementLayout();
        elementContents();
    }

    private void elementLayout(){
        GridPane customerInformationPane = new GridPane();
        Label customerInformationLabel = new Label("Receiver information");
        customerInformationPane.add(customerInformationLabel, 0,0);
        Label fullNameLabel = new Label("Full name");
        customerInformationPane.add(fullNameLabel, 0,1);
        customerInformationPane.add(orderCustomerFullName, 1,1);
        Label phoneNumber = new Label("Phone number");
        customerInformationPane.add(phoneNumber, 0,2);
        customerInformationPane.add(orderCustomerPhoneNumber, 1,2);
        Label email = new Label("Email");
        customerInformationPane.add(email, 0,3);
        customerInformationPane.add(orderCustomerEmail, 1,3);

        GridPane shippingInformationPane = new GridPane();
        Label shippingInformationLabel = new Label("Delivery information");
        shippingInformationPane.add(shippingInformationLabel, 0,0);
        Label addressLabel = new Label("Address");
        shippingInformationPane.add(addressLabel, 0,1);
        shippingInformationPane.add(orderDeliveryAdresse, 1,1);
        Label postalCodeLabel = new Label("Postal code");
        shippingInformationPane.add(postalCodeLabel, 0,2);
        shippingInformationPane.add(orderDeliveryPostalCode, 1,2);
        Label cityLabel = new Label("City");
        shippingInformationPane.add(cityLabel,0,3);
        shippingInformationPane.add(orderDeliveryCity, 1,3);
        Label countryLabel = new Label("Country");
        shippingInformationPane.add(countryLabel, 0,4);
        shippingInformationPane.add(orderDeliveryCountry, 1,4);

        this.add(customerInformationPane, 0,0);
        this.add(shippingInformationPane, 0,1);
    }

    private void elementContents(){
        // Customer information
        orderCustomerFullName.setText(selectedOrder.getCustomer().getFullName());
        orderCustomerPhoneNumber.setText(selectedOrder.getCustomer().getPhoneNo());
        orderCustomerEmail.setText(selectedOrder.getCustomer().getEmail());
        orderCustomerFullName.setEditable(false);
        orderCustomerPhoneNumber.setEditable(false);
        orderCustomerEmail.setEditable(false);
        // Address
        orderDeliveryAdresse.setText(String.format("%s %s",
                selectedOrder.getDeliveryAddress().getStreetName(),
                selectedOrder.getDeliveryAddress().getBuildingNo()
        ));
        orderDeliveryPostalCode.setText(selectedOrder.getDeliveryAddress().getPostalCode());
        orderDeliveryCity.setText(selectedOrder.getDeliveryAddress().getCity());
        orderDeliveryCountry.setText(selectedOrder.getDeliveryAddress().getCountry());
        orderDeliveryAdresse.setEditable(false);
        orderDeliveryPostalCode.setEditable(false);
        orderDeliveryCity.setEditable(false);
        orderDeliveryCountry.setEditable(false);
    }
}