package com.testfromrd.testfromrd.CatalogLayer;


import com.testfromrd.testfromrd.CatalogLayer.CatServ.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CatalogAPI1")
public class CatalogAPI {

    private final CatalogService catalogService;

    public CatalogAPI(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping
    public List<Item> getAllItems() {
        return catalogService.getAllItems();
    }

    @PostMapping
    public void addItem(@RequestBody Item newItem) {
        catalogService.addItem(newItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item updatedItem) {
        return catalogService.updateItem(id, updatedItem);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        catalogService.deleteItem(id);
    }
}