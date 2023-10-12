package com.lab3.ver1.shopitem;

import java.util.List;
import java.util.Optional;

public interface ShopItemDataI {
    List<ShopItem> selectItems();
    int insertItem(ShopItem item);
    int removeItem(Integer id);
    Optional<ShopItem> selectItemById(Integer id);
    //update?
}
