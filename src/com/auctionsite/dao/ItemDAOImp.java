package com.auctionsite.dao;
import com.auctionsite.dao.ItemDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import com.auctionsite.model.Item;
import com.auctionsite.utils.CreateConnection;
import com.auctionsite.utils.ItemStatus;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
public class ItemDAOImp implements ItemDAO {
    private final Connection con = CreateConnection.getConnection();

    @Override
    public void saveItem(Item item) {
        String query = "INSERT INTO items (seller_id, item_name, description, start_price, reserve_price, created_at) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, item.getSellerId());
            ps.setString(2, item.getItemName());
            ps.setString(3, item.getDescription());
            ps.setBigDecimal(4, item.getStartPrice());
            ps.setBigDecimal(5, item.getReservePrice());
            ps.setTimestamp(6, Timestamp.valueOf(item.getCreatedAt()));
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> getItemsBySeller(int sellerId) {
        ArrayList<Item> items = new ArrayList<>();
        String query = "SELECT * FROM items WHERE seller_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, sellerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                items.add(mapItem(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item getItemById(int itemId) {
        String query = "SELECT * FROM items WHERE item_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, itemId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapItem(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Item mapItem(ResultSet rs) throws SQLException {
        return new Item(
                rs.getInt("item_id"),
                rs.getString("item_name"),
                rs.getString("description"),
                rs.getBigDecimal("start_price"),
                rs.getBigDecimal("reserve_price"),
                rs.getInt("seller_id"),
                rs.getInt("auction_id"),
                ItemStatus.valueOf(rs.getString("status")),
                rs.getBigDecimal("listing_fee"),
                rs.getBigDecimal("res_hide_fee"),
                rs.getTimestamp("created_at").toLocalDateTime(),
                rs.getTimestamp("updated_at").toLocalDateTime()
        );
    }
}

