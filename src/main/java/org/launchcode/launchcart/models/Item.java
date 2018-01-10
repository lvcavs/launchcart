package org.launchcode.launchcart.models;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by LaunchCode
 */
@Entity
public class Item extends AbstractEntity {

    @NotNull
    @Size(min=3, max=255)
    private String name;

    @NotNull
    @Min(value = 0)
    private double price;

    private String description;

    public Item() {}

    public Item (String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Item(String name, double price) {
        this(name, price, "");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
