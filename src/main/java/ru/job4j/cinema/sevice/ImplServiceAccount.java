package ru.job4j.cinema.sevice;

import ru.job4j.cinema.dao.DaoAccount;
import ru.job4j.cinema.model.Account;

import java.util.List;

public class ImplServiceAccount implements ServiceAccount {

    private final DaoAccount daoAccount;

    public ImplServiceAccount() {
        this.daoAccount = new DaoAccount();
    }

    @Override
    public Account get(int id) {
        return daoAccount.get(id);
    }

    @Override
    public List<Account> getAll() {
        return daoAccount.getAll();
    }

    @Override
    public void save(Account account) {
        daoAccount.save(account);
    }

    @Override
    public void update(Account account) {
        daoAccount.update(account);
    }

    @Override
    public void delete(int id) {
        daoAccount.delete(id);
    }
}
