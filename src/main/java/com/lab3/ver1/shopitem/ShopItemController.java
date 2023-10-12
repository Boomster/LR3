package com.lab3.ver1.shopitem;

import org.springframework.web.bind.annotation.*;

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
        return itemService.getShopItem(id);
    }
}
