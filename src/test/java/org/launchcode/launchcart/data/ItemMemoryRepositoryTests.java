package org.launchcode.launchcart.data;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.launchcart.models.Item;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by LaunchCode
 */
public class ItemMemoryRepositoryTests {

    private ItemMemoryRepository itemMemoryRepository;

    @Before
    public void setupCart() {
       itemMemoryRepository = new ItemMemoryRepository();
       itemMemoryRepository.clear();
    }

    //TODO: test that ItemMemoryRepository can...
    // 1) save multiple items
    // 2) each item has a unique uid
    // 3) you can find the item by it's uid
    //@Test
    //public void testAddItems() {

    //}
}
