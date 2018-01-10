package org.launchcode.launchcart.controllers;

import org.launchcode.launchcart.data.CartRepository;
import org.launchcode.launchcart.data.ItemRepository;
import org.launchcode.launchcart.models.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemRepository itemRepository;

    // Support only a single user/cart for now
    private Cart getCartInstance() {
        Cart cart;
        List<Cart> results = cartRepository.findAll();
        if (results.isEmpty()) {
            cart = new Cart();
            cartRepository.save(cart);
        } else {
            cart = results.get(0);
        }
        return cart;
    }

    @ModelAttribute("cart")
    public Cart getCart() {
        return getCartInstance();
    }

    @RequestMapping
    public String displayCart(){
        return "cart/index";
    }

    @RequestMapping(value = "add-item", method = RequestMethod.POST)
    public String addItemsToCart(@RequestParam int[] ids) {
        Cart cart = getCartInstance();
        for (int id : ids) {
            cart.getItems().add(itemRepository.findOne(id));
        }
        cartRepository.save(cart);
        return "redirect:/cart";
    }

}
