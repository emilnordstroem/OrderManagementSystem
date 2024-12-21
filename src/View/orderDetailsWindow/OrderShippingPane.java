package View.orderDetailsWindow;

import Domain.Models.Order;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class OrderShippingPane extends GridPane {
    private final Order selectedOrder;

    // Receiver information overview
    private final TextField orderCustomerFullName = new TextField();
    private final TextField orderCustomerPhoneNumber = new TextField();
    private final TextField orderCustomerEmail = new TextField();
    // Delivery information overview
    private final TextField orderDeliveryAdresse = new TextField();
    private final TextField orderDeliveryPostalCode = new TextField();
    private final TextField orderDeliveryCity = new TextField();
    private final TextField orderDeliveryCountry = new TextField();
    // Shipping date overview
    private final TextField orderPlacementDateTextField = new TextField();
    private final TextField orderExpDeliveryDateTextField = new TextField();

    public OrderShippingPane(Order order) {
        this.selectedOrder = order;
        innerContent();
        this.setGridLinesVisible(false);
    }

    private void innerContent(){
        elementLayout();
        elementContents();
    }

    private void elementLayout(){
        GridPane receiverInformationPane = new GridPane();
        Label customerInformationLabel = new Label("Receiver information");
        receiverInformationPane.add(customerInformationLabel, 0,0);
        Label fullNameLabel = new Label("Full name");
        receiverInformationPane.add(fullNameLabel, 0,1);
        receiverInformationPane.add(orderCustomerFullName, 1,1);
        Label phoneNumber = new Label("Phone number");
        receiverInformationPane.add(phoneNumber, 0,2);
        receiverInformationPane.add(orderCustomerPhoneNumber, 1,2);
        Label email = new Label("Email");
        receiverInformationPane.add(email, 0,3);
        receiverInformationPane.add(orderCustomerEmail, 1,3);

        GridPane deliveryInformationPane = new GridPane();
        Label shippingInformationLabel = new Label("Delivery information");
        deliveryInformationPane.add(shippingInformationLabel, 0,0);
        Label addressLabel = new Label("Address");
        deliveryInformationPane.add(addressLabel, 0,1);
        deliveryInformationPane.add(orderDeliveryAdresse, 1,1);
        Label postalCodeLabel = new Label("Postal code");
        deliveryInformationPane.add(postalCodeLabel, 0,2);
        deliveryInformationPane.add(orderDeliveryPostalCode, 1,2);
        Label cityLabel = new Label("City");
        deliveryInformationPane.add(cityLabel,0,3);
        deliveryInformationPane.add(orderDeliveryCity, 1,3);
        Label countryLabel = new Label("Country");
        deliveryInformationPane.add(countryLabel, 0,4);
        deliveryInformationPane.add(orderDeliveryCountry, 1,4);

        GridPane dateInformationPane = new GridPane();
        Label shipmentDateInformationLabel = new Label("Shipment date information");
        dateInformationPane.add(shipmentDateInformationLabel, 0,0);
        Label orderPlacementDateLabel = new Label("Registration date");
        dateInformationPane.add(orderPlacementDateLabel, 0,1);
        dateInformationPane.add(orderPlacementDateTextField, 1,1);
        Label orderExpDeliveryDateLabel = new Label("Exp. delivery date");
        dateInformationPane.add(orderExpDeliveryDateLabel, 0,2);
        dateInformationPane.add(orderExpDeliveryDateTextField, 1,2);

        this.add(receiverInformationPane, 0,0);
        this.add(deliveryInformationPane, 0,1);
        this.add(dateInformationPane, 1,0);
    }

    private void elementContents(){
        // receiver information
        orderCustomerFullName.setText(selectedOrder.getCustomer().getFullName());
        orderCustomerPhoneNumber.setText(selectedOrder.getCustomer().getPhoneNo());
        orderCustomerEmail.setText(selectedOrder.getCustomer().getEmail());
        orderCustomerFullName.setEditable(false);
        orderCustomerPhoneNumber.setEditable(false);
        orderCustomerEmail.setEditable(false);
        // Address information
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
        // shipping date information
        orderPlacementDateTextField.setText(selectedOrder.getPlacementDate().toString());
        orderExpDeliveryDateTextField.setText(selectedOrder.getExpectedDeliveryDate().toString());
    }
}