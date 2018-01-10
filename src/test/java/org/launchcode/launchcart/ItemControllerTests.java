package org.launchcode.launchcart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.launchcode.launchcart.data.ItemRepository;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by LaunchCode
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureMockMvc
public class ItemControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testNewItemFormRenders() throws Exception {
        mockMvc.perform(get("/item/new"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("New Item")))
                .andExpect(content().string(containsString("<form")));
    }

    @Test
    public void testNewItemFormCreatesItem() throws Exception {
        String itemName = "Test Item 1";
        mockMvc.perform(post("/item/new")
                .param("name", itemName)
                .param("price", "5")
                .param("description", "A really great item"))
                .andReturn();
        mockMvc.perform(get("/item"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(itemName)));
    }

}
