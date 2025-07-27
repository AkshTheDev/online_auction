package com.auctionsite.dao;

import com.auctionsite.model.AccountTransaction;
import com.auctionsite.utils.AccountTransactionType;
import com.auctionsite.utils.CreateConnection;
import com.auctionsite.utils.TransactionStatus;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountTransactionDAOImp implements AccountTransactionDAO {
    private final Connection con = CreateConnection.getConnection();

    @Override
    public void recordTransaction(AccountTransaction tx) {
        String query = "INSERT INTO account_transactions (wallet_id, bank_account_id, amount, transaction_type, transaction_status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, tx.getWalletId());
            ps.setInt(2, tx.getBankAccountId());
            ps.setBigDecimal(3, tx.getAmount());
            ps.setString(4, tx.getTransactionType().name().toLowerCase());
            ps.setString(5, tx.getTransactionStatus().name().toLowerCase());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<AccountTransaction> getTransactionsByWallet(int walletId) {
        List<AccountTransaction> list = new ArrayList<>();
        String query = "SELECT * FROM account_transactions WHERE wallet_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, walletId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapTransaction(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateTransactionStatus(int transactionId, String newStatus) {
        String query = "UPDATE account_transactions SET transaction_status = ? WHERE account_transaction_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, newStatus);
            ps.setInt(2, transactionId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private AccountTransaction mapTransaction(ResultSet rs) throws SQLException {
        return new AccountTransaction(
                rs.getInt("account_transaction_id"),
                rs.getInt("wallet_id"),
                rs.getInt("bank_account_id"),
                rs.getBigDecimal("amount"),
                AccountTransactionType.valueOf(rs.getString("transaction_type")),
                TransactionStatus.valueOf(rs.getString("transaction_status")),
                rs.getTimestamp("created_at").toLocalDateTime()
        );
    }
}
