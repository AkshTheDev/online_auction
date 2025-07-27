package com.auctionsite.dao;
import com.auctionsite.model.Item;
import java.util.List;

public interface ItemDAO {
    void saveItem(Item item);
    List<Item> getItemsBySeller(int sellerId);
    Item getItemById(int itemId);
}

