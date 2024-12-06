package Domain.Controller;

import Domain.Models.Item;
import Storage.IDStorage;
import Storage.ItemStorage;

public class ItemController {

    public static Item createItem(String name, String description, double price){
        System.out.println("createItem() called in ItemController...");
        Item item = new Item(name, description, price);
        ItemStorage.addItem(item);
        return item;
    }

    public static void removeItem(Item item){
        System.out.println("removeCustomer() called in CustomerController...");
        ItemStorage.removeItem(item);
        IDStorage.removeItemId(item.getId());
    }
}
