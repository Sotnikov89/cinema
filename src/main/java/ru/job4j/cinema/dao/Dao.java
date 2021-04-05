package ru.job4j.cinema.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
    T getById(int id);

    List<T> getAll();

    void save(T t) throws SQLException;

    void update(T t);

    void delete(int id);
}
