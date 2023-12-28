package com.testfromrd.testfromrd.CatalogLayer;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class Singleton {

    private static final Singleton instance = new Singleton();
    private final List<Item> itemList = new ArrayList<>();

    private Singleton() {
        itemList.add(new Item(1L, "name1", "Brand1", "Description1", new BigDecimal(11.11)));
        itemList.add(new Item(2L, "name2", "Brand2", "Description2", new BigDecimal(22.22)));
    }

    public static Singleton getInstance() {
        return instance;
    }

    public List<Item> getAllItems() {
        return itemList;
    }

    public void addItem(Item newItem) {
        itemList.add(newItem);
    }

    public Item getItemById(Long id) {
        for (Item item : itemList) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public void deleteItem(Long id) {
        itemList.removeIf(item -> item.getId().equals(id));
    }
}
