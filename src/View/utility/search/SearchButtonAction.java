package View.utility.search;

import Domain.Models.Customer;
import Domain.Models.Order;
import View.utility.sort.CustomerSortAlgorithm;
import View.utility.sort.OrderSortAlgorithm;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class SearchButtonAction {

    public static ArrayList<Order> orderSearch(ArrayList<TextField> inputTextFields){;
        ArrayList<Order> sortedOrderArrayList;
        for(TextField inputTextField : inputTextFields){
            if(!inputTextField.getText().isBlank() && inputTextFields.indexOf(inputTextField) == 0){
                String orderID = inputTextField.getText();
                sortedOrderArrayList = OrderSortAlgorithm.sortedOrderArrayListByID();;
                assert sortedOrderArrayList != null;
                return OrderSearchAlgorithm.searchOrderByID(sortedOrderArrayList, orderID);

            } else if(!inputTextField.getText().isBlank() && inputTextFields.indexOf(inputTextField) == 1){
                String fullName = inputTextField.getText();
                sortedOrderArrayList = OrderSortAlgorithm.sortedOrderArrayListByName();
                assert sortedOrderArrayList != null;
                return OrderSearchAlgorithm.searchOrderByName(sortedOrderArrayList, fullName);

            } else if(!inputTextField.getText().isBlank() && inputTextFields.indexOf(inputTextField) == 2){
                String phoneNo = inputTextField.getText();
                sortedOrderArrayList = OrderSortAlgorithm.sortedOrderArrayListByPhoneNumber();
                assert sortedOrderArrayList != null;
                return OrderSearchAlgorithm.searchOrderByPhoneNumber(sortedOrderArrayList, phoneNo);

            } else if(!inputTextField.getText().isBlank() && inputTextFields.indexOf(inputTextField) == 3){
                String email = inputTextField.getText();
                sortedOrderArrayList = OrderSortAlgorithm.sortedOrderArrayListByEmail();
                assert sortedOrderArrayList != null;
                return OrderSearchAlgorithm.searchOrderByEmail(sortedOrderArrayList, email);
            }
        }
        return null;
    }

    public static ArrayList<Customer> searchCustomer(ArrayList<TextField> inputTextFields){
        ArrayList<Customer> sortedCustomerArrayList;
        for(TextField inputTextField : inputTextFields){
            if(!inputTextField.getText().isBlank() && inputTextFields.indexOf(inputTextField) == 0){
                String customerID = inputTextField.getText();
                sortedCustomerArrayList = CustomerSortAlgorithm.sortedCustomerArrayListByID();
                assert sortedCustomerArrayList != null;
                return CustomerSearchAlgorithm.searchCustomerByID(sortedCustomerArrayList, customerID);

            } else if(!inputTextField.getText().isBlank() && inputTextFields.indexOf(inputTextField) == 1){
                String fullName = inputTextField.getText();
                sortedCustomerArrayList = CustomerSortAlgorithm.sortedCustomerArrayListByName();
                assert sortedCustomerArrayList != null;
                return CustomerSearchAlgorithm.searchCustomerByName(sortedCustomerArrayList, fullName);

            } else if(!inputTextField.getText().isBlank() && inputTextFields.indexOf(inputTextField) == 2){
                String phoneNumber = inputTextField.getText();
                sortedCustomerArrayList = CustomerSortAlgorithm.sortedCustomerArrayListByPhoneNo();
                assert sortedCustomerArrayList != null;
                return CustomerSearchAlgorithm.searchCustomerByPhoneNo(sortedCustomerArrayList, phoneNumber);

            } else if(!inputTextField.getText().isBlank() && inputTextFields.indexOf(inputTextField) == 3){
                String email = inputTextField.getText();
                sortedCustomerArrayList = CustomerSortAlgorithm.sortedCustomerArrayListByEmail();
                assert sortedCustomerArrayList != null;
                return CustomerSearchAlgorithm.searchCustomerByEmail(sortedCustomerArrayList, email);
            }
        }
        return null;
    }
}