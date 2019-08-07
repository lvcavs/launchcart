package org.launchcode.launchcart.models;



/**
 * Created by LaunchCode
 */
public class Item extends AbstractEntity {

    private String name;

    private double price;

    private String description;

    public Item() {
        super();
    }

    public Item (String name, double price, String description) {
        this();
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
