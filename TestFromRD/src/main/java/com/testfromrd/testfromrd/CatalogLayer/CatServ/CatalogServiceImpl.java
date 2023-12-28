package com.testfromrd.testfromrd.CatalogLayer.CatServ;

import com.testfromrd.testfromrd.CatalogLayer.Item;
import com.testfromrd.testfromrd.CatalogLayer.Singleton;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CatalogServiceImpl implements CatalogService {
    private final Singleton catalogSingleton = Singleton.getInstance();

    @Override
    public List<Item> getAllItems() {
        return catalogSingleton.getAllItems();
    }

    @Override
    public void addItem(Item newItem) {
        catalogSingleton.addItem(newItem);
    }

    @Override
    public ResponseEntity<Item> updateItem(Long id, Item updatedItem) {
        Item existingItem = catalogSingleton.getItemById(id);

        if (existingItem != null) {
            existingItem.setName(updatedItem.getName());
            existingItem.setBrand(updatedItem.getBrand());
            existingItem.setDescription(updatedItem.getDescription());
            existingItem.setCost(updatedItem.getCost());

            return ResponseEntity.ok(existingItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public void deleteItem(Long id) {
        catalogSingleton.deleteItem(id);
    }
}