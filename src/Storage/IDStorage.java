package Storage;

import java.util.ArrayList;

public class IDStorage {
    private static ArrayList<String> CUSTOMERIDS = new ArrayList<>();
    private static ArrayList<String> ORDERIDS = new ArrayList<>();
    private static ArrayList<String> ITEMIDS = new ArrayList<>();

    //=================================================================
    // CustomerID
    public static boolean customerIdentificationAlreadyExist(String identification){
        return CUSTOMERIDS.contains(identification);
    }

    public static void addCustomerID(String identification){
        if(!CUSTOMERIDS.contains(identification)){
            CUSTOMERIDS.add(identification);
            System.out.println("Customer identification was added to IDStorage");
        }
    }

    public static void removeCustomerId(String identification){
        CUSTOMERIDS.remove(identification);
        System.out.println("Customer identification was removed from IDStorage");
    }

    //=================================================================
    // OrderID
    public static boolean orderIdentificationAlreadyExist(String identification){
        return ORDERIDS.contains(identification);
    }

    public static void addOrderId(String identification){
        if(!ORDERIDS.contains(identification)){
            ORDERIDS.add(identification);
            System.out.println("Order identification was added to IDStorage");
        }
    }

    public static void removeOrderId(String identification){
        ORDERIDS.remove(identification);
        System.out.println("Order identification was removed from IDStorage");
    }

    //=================================================================
    // ItemID
    public static boolean itemIdentificationAlreadyExist(String identification){
        return ITEMIDS.contains(identification);
    }

    public static void addItemId(String identification){
        if(!ITEMIDS.contains(identification)){
            ITEMIDS.add(identification);
            System.out.println("item identification was added to IDStorage");
        }
    }

    public static void removeItemId(String identification){
        ITEMIDS.remove(identification);
        System.out.println("Item identification was removed from IDStorage");
    }
}
