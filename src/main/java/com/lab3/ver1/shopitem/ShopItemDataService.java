package com.lab3.ver1.shopitem;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ShopItemDataService implements ShopItemDataI {
    @Override
    public List<ShopItem> selectItems() {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public int insertItem(ShopItem item) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public int removeItem(Integer id) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public Optional<ShopItem> selectItemById(Integer id) {
        throw new UnsupportedOperationException("not implemented yet");
    }
}
