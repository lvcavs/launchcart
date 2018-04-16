package org.launchcode.launchcart.data;

import org.launchcode.launchcart.models.Cart;

import java.util.ArrayList;
import java.util.List;

public class CartMemoryRepository {

    private static ArrayList<Cart> cartStorage = new ArrayList<>();

    public List<Cart> findAll() {
        return new ArrayList<>(cartStorage);
    }

    public void save(Cart cart) {
        cartStorage.add(cart);
    }

    public void clear() {
        cartStorage.clear();
    }

}
