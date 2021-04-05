package ru.job4j.cinema.dao;

import ru.job4j.cinema.model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoAccount implements Dao<Account> {

    @Override
    public Account getById(int id) {
        Account account = new Account();
        String sql = "SELECT * FROM account WHERE id=?";
        try (Connection cn = DbConnection.getConnection(); PreparedStatement ps =  cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    account.setId(rs.getInt("id"));
                    account.setName(rs.getString("name"));
                    account.setEmail(rs.getString("email"));
                    account.setPhone(rs.getString("phone"));
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return account;
    }

    @Override
    public List<Account> getAll() {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM account";
        try (Connection cn = DbConnection.getConnection();
             PreparedStatement ps =  cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    accounts.add(new Account(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("phone")));
                }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return accounts;
    }

    @Override
    public void save(Account account) throws SQLException {
        String sql = "INSERT INTO account(name, email, phone) VALUES (?, ?, ?)";
        try (Connection cn = DbConnection.getConnection();
             PreparedStatement ps =  cn.prepareStatement(sql)) {
            ps.setString(1, account.getName());
            ps.setString(2, account.getEmail());
            ps.setString(3, account.getPhone());
            ps.execute();
        }
    }

    @Override
    public void update(Account account) {
        String sql = "UPDATE account SET name = ?, email = ?, phone = ? WHERE id = ?";
        try (Connection cn = DbConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, account.getName());
            ps.setString(2, account.getEmail());
            ps.setString(3, account.getPhone());
            ps.setInt(4, account.getId());
            ps.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM account WHERE id = ?";
        try (Connection cn = DbConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public Integer getIdByPhoneOrNull(String phone) {
        String sql = "SELECT id FROM account WHERE phone = ?";
        Integer id = null;
        try (Connection cn = DbConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, phone);
            try (ResultSet it = ps.executeQuery()) {
                while (it.next()) {
                    id = it.getInt("id");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
}
