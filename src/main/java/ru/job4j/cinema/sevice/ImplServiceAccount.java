package ru.job4j.cinema.sevice;

import ru.job4j.cinema.dao.DaoAccount;
import ru.job4j.cinema.model.Account;

import java.sql.SQLException;
import java.util.List;

public class ImplServiceAccount implements ServiceAccount {

    private final DaoAccount daoAccount;

    private ImplServiceAccount() {
        this.daoAccount = new DaoAccount();
    }

    public static ImplServiceAccount instOf() {
        return new ImplServiceAccount();
    }

    @Override
    public Account getById(int id) {
        return daoAccount.getById(id);
    }

    @Override
    public List<Account> getAll() {
        return daoAccount.getAll();
    }

    @Override
    public void save(Account account) throws SQLException { daoAccount.save(account); }

    @Override
    public void update(Account account) {
        daoAccount.update(account);
    }

    @Override
    public void delete(int id) {
        daoAccount.delete(id);
    }

    @Override
    public int saveAndGetIdOrGetId(Account account) {
        int idAccount = 0;
        try {
            new DaoAccount().save(account);
            idAccount = new DaoAccount().getIdByPhoneOrNull(account.getPhone());
        } catch (SQLException exception) {
            idAccount = new DaoAccount().getIdByPhoneOrNull(account.getPhone());
        }
        return idAccount;
    }
}
