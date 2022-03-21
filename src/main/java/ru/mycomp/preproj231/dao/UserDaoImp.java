package ru.mycomp.preproj231.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class UserDaoImp implements UserDao{
    private final String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
    private final String username = "postgres";
    private final String password = "postgres";

    @PostConstruct
    @Override
    public void createDatabase() {
            String sql = "CREATE TABLE IF NOT EXISTS USERS" +
                    "(id serial PRIMARY KEY, " +
                    " name VARCHAR(255), " +
                    " lastName VARCHAR(255), " +
                    " age INTEGER)";
            try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
                 Statement stmt = connection.createStatement()) {
                stmt.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Table created");
        }
    }


/*
    public void save(UserHuuzer user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.save(user);
            tx1.commit();
        }
    }

    public void update(UserHuuzer user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.update(user);
            tx1.commit();
        }
    }

    public void delete(UserHuuzer user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.delete(user);
            tx1.commit();
        }
    }

    public UserHuuzer findByLogin(String login) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(UserHuuzer.class, login);
        }
    }*/
