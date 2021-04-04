package ru.job4j.cinema.dao;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
    private final BasicDataSource pool = new BasicDataSource();

    private DbConnection() {
        Properties cfg = new Properties();
        try (BufferedReader io = new BufferedReader(new FileReader("cinemaDB.properties"))) {
            cfg.load(io);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        try {
            Class.forName(cfg.getProperty("jdbc.driver"));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        pool.setDriverClassName(cfg.getProperty("jdbc.driver"));
        pool.setUrl(cfg.getProperty("jdbc.url"));
        pool.setUsername(cfg.getProperty("jdbc.username"));
        pool.setPassword(cfg.getProperty("jdbc.password"));
        pool.setMinIdle(5);
        pool.setMaxIdle(10);
        pool.setMaxOpenPreparedStatements(100);
    }

    private static final class Lazy {
        private static final DbConnection INST = new DbConnection();
    }

    public static DbConnection instOf() {
        return DbConnection.Lazy.INST;
    }

    public static Connection getConnection() throws SQLException {
        return DbConnection.instOf().pool.getConnection();
    }
}
