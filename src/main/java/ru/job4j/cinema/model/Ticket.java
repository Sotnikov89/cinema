package ru.job4j.cinema.model;

import java.util.Objects;

public class Ticket {
    private int id;
    private int row;
    private int cell;
    private int account_id;

    public Ticket() {
    }

    public Ticket(int row, int cell, int account_id) {
        this.row = row;
        this.cell = cell;
        this.account_id = account_id;
    }

    public Ticket(int id, int row, int cell, int account_id) {
        this.id = id;
        this.row = row;
        this.cell = cell;
        this.account_id = account_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCell() {
        return cell;
    }

    public void setCell(int cell) {
        this.cell = cell;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
