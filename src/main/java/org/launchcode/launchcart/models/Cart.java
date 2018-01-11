package org.launchcode.launchcart.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LaunchCode
 */
@Entity
public class Cart extends AbstractEntity {

    @OneToMany
    @JoinColumn(name = "cart_uid")
    private List<Item> items = new ArrayList<>();

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

}
