package org.launchcode.launchcart.controllers;

import org.launchcode.launchcart.data.ItemRepository;
import org.launchcode.launchcart.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String viewAllItems(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        return "item/index";
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String displayCreateNewItemForm(Model model) {
        model.addAttribute(new Item());
        model.addAttribute("title", "New Item");
        return "item/new";
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String createNewItem(@ModelAttribute @Valid Item item, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "New Item");
            return "item/new";
        }

        itemRepository.save(item);

        return "redirect:item";
    }

}
