package ru.job4j.cinema.sevice;

import ru.job4j.cinema.dao.DaoTicket;
import ru.job4j.cinema.model.Ticket;

import java.util.List;

public class ImplServiceTicket implements ServiceTicket {

    private final DaoTicket daoTicket;

    public ImplServiceTicket() {
        this.daoTicket = new DaoTicket();
    }

    @Override
    public Ticket get(int id) {
        return daoTicket.get(id);
    }

    @Override
    public List<Ticket> getAll() {
        return daoTicket.getAll();
    }

    @Override
    public void save(Ticket ticket) {
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
