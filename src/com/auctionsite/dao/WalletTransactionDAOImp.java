package com.auctionsite.dao;

import com.auctionsite.model.WalletTransaction;
import com.auctionsite.utils.CreateConnection;
import com.auctionsite.utils.TransactionStatus;
import com.auctionsite.utils.WalletTransactionType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WalletTransactionDAOImp implements WalletTransactionDAO {
    private final Connection con = CreateConnection.getConnection();

    @Override
    public void recordTransaction(WalletTransaction tx) {
        String query = "INSERT INTO wallet_transactions(from_wallet_id, to_wallet_id, amount, transaction_type, transaction_status) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, tx.getFromWalletId());
            ps.setInt(2, tx.getToWalletId());
            ps.setBigDecimal(3, tx.getAmount());
            ps.setString(4, tx.getTransactionType().name());
            ps.setString(5, tx.getTransactionStatus().name());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<WalletTransaction> getTransactionsByWallet(int walletId) {
        List<WalletTransaction> list = new ArrayList<>();
        String query = "SELECT * FROM wallet_transactions WHERE from_wallet_id = ? OR to_wallet_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, walletId);
            ps.setInt(2, walletId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapWalletTransaction(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateTransactionStatus(int transactionId, String newStatus) {
        String query = "UPDATE wallet_transactions SET transaction_status = ? WHERE wallet_transaction_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, TransactionStatus.valueOf(newStatus).name()); // Safely validate enum
            ps.setInt(2, transactionId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private WalletTransaction mapWalletTransaction(ResultSet rs) throws SQLException {
        return new WalletTransaction(
                rs.getInt("wallet_transaction_id"),
                rs.getInt("from_wallet_id"),
                rs.getInt("to_wallet_id"),
                rs.getBigDecimal("amount"),
                WalletTransactionType.valueOf(rs.getString("transaction_type")),
                TransactionStatus.valueOf(rs.getString("transaction_status")),
                rs.getTimestamp("created_at").toLocalDateTime()
        );
    }
}
