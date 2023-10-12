package com.lab3.ver1.shopitem;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin
public class ShopItemController {
    private final ShopItemService itemService;

    public ShopItemController(ShopItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<ShopItem> listShopItems(){
        return itemService.getShopItems();
    }

    @GetMapping("/{id}")
    public ShopItem getShopItemById(@PathVariable("id") Integer id){
        return itemService.getShopItem(id).
                orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "No item with id: " + id + " is found!"));
    }

    @PostMapping
    public void addShopItem(@RequestBody ShopItem newItem){
        itemService.addShopItem(newItem);
    }

    @DeleteMapping("{id}")
    public void deleteShopItem(@PathVariable("id") Integer id){
        itemService.deleteShopItem(id);
    }
}
