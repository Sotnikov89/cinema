package ru.job4j.cinema.dao;

import java.util.List;

public interface Dao<T> {
    T get(int id);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(int id);
}
