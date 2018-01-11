package org.launchcode.launchcart.models;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by LaunchCode
 */
public class TestCart {

    private Cart cart;

    @Before
    public void setupCart() {
        cart = new Cart();
    }

    @Test
    public void testAddItem() {
        Item item = new Item("Test Item", 5);
        assertFalse(cart.getItems().contains(item));
        cart.addItem(item);
        assertTrue(cart.getItems().contains(item));
    }
}
