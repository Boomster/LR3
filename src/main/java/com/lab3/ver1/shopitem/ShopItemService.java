package com.lab3.ver1.shopitem;

import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class ShopItemService {
    private final JdbcTemplate jdbcTemplate;

    public ShopItemService(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<ShopItem> getShopItems(Integer startFrom) {
        var sql = """
                SELECT id, name, price, genre, image_link
                FROM items
                LIMIT 9
                OFFSET ?
                """;
        try{
            return jdbcTemplate.query(sql, new ShopItemRowMapper(), startFrom);
        }
        catch (SQLException e)
        {
            return List.of();
        }
    }

    public Integer getShopItemsCount() {
        var sql = """
                SELECT COUNT(*)
                FROM items
                """;
        try{
            return jdbcTemplate.queryForInt(sql);
        }
        catch (SQLException e)
        {
            return 0;
        }
    }

    public Optional<ShopItem> getShopItem(Integer id) {
        var sql = """
                SELECT id, name, price, genre, image_link
                FROM items
                WHERE id = ?
                """;
        List<ShopItem> items = List.of();
        try{
            items = jdbcTemplate.query(sql, new ShopItemRowMapper(), id);
            return items.stream().findFirst();
        }
        catch (SQLException ignore){}
        return null;
    }
}
