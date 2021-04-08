package ru.job4j.cinema.sevice;

import ru.job4j.cinema.dao.Dao;
import ru.job4j.cinema.model.Account;

public interface ServiceAccount extends Dao<Account> {
    int saveAndGetIdOrGetId(Account account);
}
