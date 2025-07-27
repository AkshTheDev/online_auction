package com.auctionsite.dao;

import com.auctionsite.model.WalletTransactionBreakdown;
import com.auctionsite.utils.CreateConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WalletTransactionBreakdownDAOImp implements WalletTransactionBreakdownDAO {
    private final Connection con = CreateConnection.getConnection();

    @Override
    public void addBreakdown(WalletTransactionBreakdown breakdown) {
        String query = "INSERT INTO wallet_transaction_breakdown(wallet_transaction_id, amount, description) VALUES (?, ?, ?)";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, breakdown.getWalletTransactionId());
            ps.setBigDecimal(2, breakdown.getAmount());
            ps.setString(3, breakdown.getDescription());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<WalletTransactionBreakdown> getBreakdownsForTransaction(int walletTransactionId) {
        List<WalletTransactionBreakdown> list = new ArrayList<>();
        String query = "SELECT * FROM wallet_transaction_breakdown WHERE wallet_transaction_id = ?";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, walletTransactionId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapBreakdown(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private WalletTransactionBreakdown mapBreakdown(ResultSet rs) throws SQLException {
        return new WalletTransactionBreakdown(
                rs.getInt("breakdown_id"),
                rs.getInt("wallet_transaction_id"),
                rs.getBigDecimal("amount"),
                rs.getString("description"),
                rs.getTimestamp("created_at").toLocalDateTime()
        );
    }
}
