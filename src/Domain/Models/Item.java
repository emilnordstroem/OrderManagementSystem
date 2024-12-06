package Domain.Models;

import Storage.IDStorage;

import java.util.Random;

public class Item {
    private String id;
    private String name;
    private String description;
    private double price;

    public Item(String name, String description, double price) {
        this.id = generateID();
        this.name = name;
        this.description = description;
        this.price = price;
    }

    protected String generateID(){
        String id = String.valueOf(new Random().nextInt(1_111, 9_999) + 1);
        while(IDStorage.itemIdentificationAlreadyExist(id)){
            id = String.valueOf(new Random().nextInt(1_111, 9_999) + 1);
        }
        IDStorage.addItemId(id);
        return id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
