package org.launchcode.launchcart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.launchcode.launchcart.data.CartRepository;
import org.launchcode.launchcart.data.ItemRepository;
import org.launchcode.launchcart.models.Cart;
import org.launchcode.launchcart.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by LaunchCode
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureMockMvc
public class CartControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testCanSaveItemToCartAndRedirect() throws Exception {
        Cart cart = new Cart();
        cartRepository.save(cart);
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
