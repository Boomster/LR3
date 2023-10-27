package com.lab3.ver1.shopitem;

import org.springframework.web.bind.annotation.*;

import java.nio.file.FileSystemNotFoundException;
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
        return itemService.getShopItems(0);
    }

    @GetMapping("/{id}")
    public ShopItem getShopItemById(@PathVariable("id") Integer id){
        return itemService.getShopItem(id)
                .orElseThrow(() -> new FileSystemNotFoundException(String.format("Item with id %s not found", id)));
    }
    @GetMapping("/start/{num}")
    public List<ShopItem> listShopItems(@PathVariable("num") Integer num) {return itemService.getShopItems(num);}

    @GetMapping("/count")
    public Integer getShopItemsCount() {return itemService.getShopItemsCount();}
}
