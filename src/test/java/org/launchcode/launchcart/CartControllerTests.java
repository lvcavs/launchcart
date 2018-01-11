package org.launchcode.launchcart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.launchcode.launchcart.data.CartRepository;
import org.launchcode.launchcart.data.ItemRepository;
import org.launchcode.launchcart.models.Cart;
import org.launchcode.launchcart.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by LaunchCode
 */
@RunWith(SpringRunner.class)
@IntegrationTestConfig
public class CartControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testCanSaveItemToCartAndRedirect() throws Exception {
        Item item = new Item("Test Item", 5);
        itemRepository.save(item);
        mockMvc.perform(post("/cart/add-item/")
                .param("ids", Integer.toString(item.getUid())))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "/cart"));
        mockMvc.perform(get("/cart/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(item.getName())));
    }

}
