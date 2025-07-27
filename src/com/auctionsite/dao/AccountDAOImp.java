package com.auctionsite.dao;

import com.auctionsite.model.Account;
import com.auctionsite.utils.CreateConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImp implements AccountDAO {
    private final Connection con = CreateConnection.getConnection();

    @Override
    public void addAccount(Account account) {
        String query = "INSERT INTO bank_accounts (user_id, account_number, ifsc_code, bank_name) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, account.getUserId());
            ps.setString(2, account.getAccountNumber());
            ps.setString(3, account.getIfscCode());
            ps.setString(4, account.getBankName());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account getAccountById(int accountId) {
        String query = "SELECT * FROM bank_accounts WHERE bank_account_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, accountId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapAccount(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Account> getAccountsByUserId(int userId) {
        List<Account> list = new ArrayList<>();
        String query = "SELECT * FROM bank_accounts WHERE user_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapAccount(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private Account mapAccount(ResultSet rs) throws SQLException {
        return new Account(
                rs.getInt("bank_account_id"),
                rs.getInt("user_id"),
                rs.getString("account_number"),
                rs.getString("ifsc_code"),
                rs.getString("bank_name"),
                rs.getTimestamp("created_at").toLocalDateTime()
        );
    }
}
