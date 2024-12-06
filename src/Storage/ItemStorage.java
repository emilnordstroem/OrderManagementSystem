package Storage;

import Domain.Models.Item;

import java.util.ArrayList;

public class ItemStorage {
    private static final ArrayList<Item> ITEMS = new ArrayList<>();

    //=================================================================
    // Order
    public static void addItem(Item item){
        if(!ITEMS.contains(item)){
            ITEMS.add(item);
            System.out.println(String.format("%s added to ITEMS in CustomerStorage", item.getName()));
        } else {
            System.out.println(String.format("%s already added to ITEMS in CustomerStorage", item.getName()));
        }
    }

    public static void removeItem(Item item){
        ITEMS.remove(item);
        System.out.printf("%s removed from ITEMS in ItemStorage%n", item.getName());
    }

    public static ArrayList<Item> getItems(){
        return new ArrayList<>(ITEMS);
    }
}
