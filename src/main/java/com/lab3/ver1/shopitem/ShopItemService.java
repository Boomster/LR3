package com.lab3.ver1.shopitem;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public class ShopItemService {
    private final ShopItemDataI shopItemDataControl;

    public ShopItemService(ShopItemDataI shopItemDataControl) {
        this.shopItemDataControl = shopItemDataControl;
    }

    public List<ShopItem> getShopItems() {
        return shopItemDataControl.selectItems();
    }

    public Optional<ShopItem> getShopItem(Integer id) {
        return shopItemDataControl.selectItemById(id);
    }

    public void addShopItem(ShopItem newItem){

        int result = shopItemDataControl.insertItem(newItem);
        if (result != 1) {
            throw new IllegalStateException("Something went wrong! Couldn't add new item.");
        }
    }

    public void deleteShopItem(Integer id){
        Optional<ShopItem> items = shopItemDataControl.selectItemById(id);
        items.ifPresentOrElse(item -> {
                    int result = shopItemDataControl.removeItem(id);
                    if (result != 1) {
                        throw new IllegalStateException("Could not delete item!");
                    }
                }, () -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No item with id: " + id + " is found!");
        });
    }
}
