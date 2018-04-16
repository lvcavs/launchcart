package org.launchcode.launchcart.data;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.launchcart.models.Cart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by LaunchCode
 */
public class CartMemoryRepositoryTests {

    private CartMemoryRepository cartMemoryRepository;

    @Before
    public void setupCart() {
       cartMemoryRepository = new CartMemoryRepository();
       cartMemoryRepository.clear();
    }

    @Test
    public void testAddCarts() {
        Cart item1 = new Cart();
        Cart item2 = new Cart();

        cartMemoryRepository.save(item1);
        cartMemoryRepository.save(item2);

        assertEquals("both were stored", cartMemoryRepository.findAll().size(), 2);
        assertTrue("id is not zero or null", cartMemoryRepository.findAll().get(0).getUid() != 0);
        assertTrue("ids should not be equal", cartMemoryRepository.findAll().get(0).getUid() != cartMemoryRepository.findAll().get(1).getUid());
    }
}
