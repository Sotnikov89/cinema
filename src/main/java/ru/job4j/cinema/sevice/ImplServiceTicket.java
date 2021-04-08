package ru.job4j.cinema.sevice;

import ru.job4j.cinema.dao.DaoTicket;
import ru.job4j.cinema.model.Ticket;

import java.sql.SQLException;
import java.util.List;

public class ImplServiceTicket implements ServiceTicket {

    private final DaoTicket daoTicket;

    private ImplServiceTicket() {
        this.daoTicket = new DaoTicket();
    }

    public static ImplServiceTicket instOf() {
        return new ImplServiceTicket();
    }

    @Override
    public Ticket getById(int id) {
        return daoTicket.getById(id);
    }

    @Override
    public List<Ticket> getAll() {
        return daoTicket.getAll();
    }

    @Override
    public void save(Ticket ticket) throws SQLException {
        daoTicket.save(ticket);
    }

    @Override
    public void update(Ticket ticket) {
        daoTicket.update(ticket);
    }

    @Override
    public void delete(int id) {
        daoTicket.delete(id);
    }
}
