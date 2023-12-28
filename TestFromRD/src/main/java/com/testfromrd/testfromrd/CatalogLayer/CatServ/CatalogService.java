package com.testfromrd.testfromrd.CatalogLayer.CatServ;

import com.testfromrd.testfromrd.CatalogLayer.Item;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface CatalogService {
    List<Item> getAllItems();
    void addItem(Item newItem);
    ResponseEntity<Item> updateItem(Long id, Item updatedItem);
    void deleteItem(Long id);
}