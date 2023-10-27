package com.lab3.ver1.shopitem;

import org.flywaydb.core.internal.jdbc.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShopItemRowMapper implements RowMapper<ShopItem> {
    @Override
    public ShopItem mapRow(ResultSet resultSet) throws SQLException {
        return new ShopItem(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getDouble("price"),
                resultSet.getString("genre"),
                resultSet.getString("image_link")
        );
    }
}
