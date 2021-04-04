package ru.job4j.cinema.dao;

import ru.job4j.cinema.model.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoTicket implements Dao<Ticket> {

    @Override
    public Ticket get(int id) {
        Ticket ticket = new Ticket();
        String sql = "SELECT * FROM ticket WHERE id=?";
        try (Connection cn = DbConnection.getConnection(); PreparedStatement ps =  cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ticket.setId(rs.getInt("id"));
                    ticket.setRow(rs.getInt("row"));
                    ticket.setCell(rs.getInt("cell"));
                    ticket.setAccount_id(rs.getInt("account_id"));
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return ticket;
    }

    @Override
    public List<Ticket> getAll() {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM ticket";
        try (Connection cn = DbConnection.getConnection();
             PreparedStatement ps =  cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                tickets.add(new Ticket(rs.getInt("id"),
                        rs.getInt("row"),
                        rs.getInt("cell"),
                        rs.getInt("account_id")));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return tickets;
    }

    @Override
    public void save(Ticket ticket) {
        String sql = "INSERT INTO ticket(row, cell, account_id) VALUES (?, ?, ?)";
        try (Connection cn = DbConnection.getConnection();
             PreparedStatement ps =  cn.prepareStatement(sql)) {
            ps.setInt(1, ticket.getRow());
            ps.setInt(2, ticket.getCell());
            ps.setInt(3, ticket.getAccount_id());
            ps.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Ticket ticket) {
        String sql = "UPDATE ticket SET row = ?, cell = ?, account_id = ? WHERE id = ?";
        try (Connection cn = DbConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, ticket.getRow());
            ps.setInt(2, ticket.getCell());
            ps.setInt(3, ticket.getAccount_id());
            ps.setInt(4, ticket.getId());
            ps.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM ticket WHERE id = ?";
        try (Connection cn = DbConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
