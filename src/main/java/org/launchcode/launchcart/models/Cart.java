package org.launchcode.launchcart.models;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by LaunchCode
 */
public class Cart extends AbstractEntity {

    private List<Item> items = new ArrayList<>();

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

}
