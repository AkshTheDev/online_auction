package com.auctionsite.dao;

import com.auctionsite.model.WinningBid;
import com.auctionsite.utils.CreateConnection;
import com.auctionsite.utils.TransactionStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WinningBidDAOImp implements WinningBidDAO {
    private final Connection con = CreateConnection.getConnection();

    @Override
    public void recordWinningBid(WinningBid winBid) {
        String query = "INSERT INTO winning_bids(item_id, bid_id, conversion_fee, transaction_fee) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, winBid.getItem_id());
            ps.setInt(2, winBid.getBid_id());
            ps.setBigDecimal(3, winBid.getConversion_fee());
            ps.setBigDecimal(4, winBid.getTransaction_fee());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public WinningBid getByItemId(int itemId) {
        String query = "SELECT * FROM winning_bids WHERE item_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, itemId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return mapWinningBid(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<WinningBid> getAllWinningBids() {
        List<WinningBid> list = new ArrayList<>();
        String query = "SELECT * FROM winning_bids";
        try (PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) list.add(mapWinningBid(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updatePaymentStatus(int winId, TransactionStatus status) {
        String query = "UPDATE winning_bids SET payment_status = ? WHERE win_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, status.name());
            ps.setInt(2, winId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private WinningBid mapWinningBid(ResultSet rs) throws SQLException {
        return new WinningBid(
                rs.getInt("win_id"),
                rs.getInt("item_id"),
                rs.getInt("bid_id"),
                rs.getBigDecimal("conversion_fee"),
                rs.getBigDecimal("transaction_fee"),
                TransactionStatus.valueOf(rs.getString("payment_status")),  // Or convert to enum
                rs.getTimestamp("created_at").toLocalDateTime()
        );
    }
}
