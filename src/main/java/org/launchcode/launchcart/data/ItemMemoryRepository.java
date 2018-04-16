package org.launchcode.launchcart.data;

import org.launchcode.launchcart.models.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemMemoryRepository {

    private static ArrayList<Item> itemStorage = new ArrayList<>();

    public List<Item> findAll() {
        return new ArrayList<>(itemStorage);
    }

    public Item findOne(int id) {
        Optional<Item> result = itemStorage
                .stream()
                .filter(item -> item.getUid() == id)
                .findFirst();

        return result.get();
    }

    public void save(Item item) {
        itemStorage.add(item);
    }

    public void clear() {
        itemStorage.clear();
    }
}
