package View.utility;

import Domain.Models.Customer;
import Domain.Models.Order;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class SearchButtonAction {
    public static ArrayList<Order> orderSearch(ArrayList<TextField> inputTextFields){;
        for(TextField inputTextField : inputTextFields){
            if(!inputTextField.getText().isBlank() && inputTextFields.indexOf(inputTextField) == 0){
                String orderID = inputTextField.getText();
                ArrayList<Order> sortedOrderArrayList = SortAlgorithm.sortedOrderArrayListByID();
                return SearchAlgorithm.searchOrderByID(sortedOrderArrayList, orderID);
            } else if(!inputTextField.getText().isBlank() && inputTextFields.indexOf(inputTextField) == 1){
                String fullName = inputTextField.getText();
                ArrayList<Order> sortedOrderArrayList = SortAlgorithm.sortedOrderArrayListByName();
                return SearchAlgorithm.searchOrderByName(sortedOrderArrayList, fullName);
            } else if(!inputTextField.getText().isBlank() && inputTextFields.indexOf(inputTextField) == 2){
                String phoneNumber = inputTextField.getText();
                ArrayList<Order> sortedOrderArrayList = SortAlgorithm.sortedOrderArrayListByPhoneNumber();
                return SearchAlgorithm.searchOrderByPhoneNumber(sortedOrderArrayList, phoneNumber);
            } else if(!inputTextField.getText().isBlank() && inputTextFields.indexOf(inputTextField) == 2){
                String email = inputTextField.getText();
                ArrayList<Order> sortedOrderArrayList = SortAlgorithm.sortedOrderArrayListByEmail();
                return SearchAlgorithm.searchOrderByEmail(sortedOrderArrayList, email);
            }
        }
        return null;
    }

    public static Customer searchCustomer(ArrayList<TextField> inputTextFields){
//        for(TextField inputTextField : inputTextFields){
//            if(!inputTextField.getText().isBlank() && inputTextFields.indexOf(inputTextField) == 0){
//                String customerID = inputTextField.getText();
//                ArrayList<Customer> sortedCustomerArrayList = SearchAlgorithm.sortedOrderArrayListByID();
//                return SearchAlgorithm.searchCustomerByID(sortedCustomerArrayList, customerID);
//            } else if(!inputTextField.getText().isBlank() && inputTextFields.indexOf(inputTextField) == 1){
//                String fullName = inputTextField.getText();
//                ArrayList<Order> sortedOrderArrayList = SearchAlgorithm.sortedOrderArrayListByName();
//                return SearchAlgorithm.searchOrderByName(sortedOrderArrayList, fullName);
//            } else if(!inputTextField.getText().isBlank() && inputTextFields.indexOf(inputTextField) == 2){
//                String phoneNumber = inputTextField.getText();
//                ArrayList<Order> sortedOrderArrayList = SearchAlgorithm.sortedOrderArrayListByPhoneNumber();
//                return SearchAlgorithm.searchOrderByPhoneNumber(sortedOrderArrayList, phoneNumber);
//            } else if(!inputTextField.getText().isBlank() && inputTextFields.indexOf(inputTextField) == 2){
//                String email = inputTextField.getText();
//                ArrayList<Order> sortedOrderArrayList = SearchAlgorithm.sortedOrderArrayListByEmail();
//                return SearchAlgorithm.searchOrderByEmail(sortedOrderArrayList, email);
//            }
//        }
        return null;
    }
}