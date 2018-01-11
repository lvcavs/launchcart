package org.launchcode.launchcart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.launchcode.launchcart.data.ItemRepository;
import org.launchcode.launchcart.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.text.StringContainsInOrder.stringContainsInOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by LaunchCode
 */
@RunWith(SpringRunner.class)
@IntegrationTestConfig
public class ItemControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testItemIndexListsAllItems() throws Exception {

        itemRepository.save(new Item("Test Item 1", 1));
        itemRepository.save(new Item("Test Item 2", 1));
        itemRepository.save(new Item("Test Item 3", 1));
        itemRepository.save(new Item("Test Item 4", 1));

        List<Item> items = itemRepository.findAll();
        List<String> names = new ArrayList<>();
        for (Item item : items) {
            names.add(item.getName());
        }
        mockMvc.perform(get("/item"))
                .andExpect(status().isOk())
                .andExpect(content().string(stringContainsInOrder(names)));
    }

    @Test
    public void testNewItemFormRenders() throws Exception {
        mockMvc.perform(get("/item/new"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("New Item")))
                .andExpect(content().string(containsString("<form")));
    }

    @Test
    public void testNewItemFormCreatesItemAndRedirects() throws Exception {
        String itemName = "Test Item Save";
        mockMvc.perform(post("/item/new")
                .param("name", itemName)
                .param("price", "5")
                .param("description", "A really great item"))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "/item"));
        mockMvc.perform(get("/item"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(itemName)));
    }

}
