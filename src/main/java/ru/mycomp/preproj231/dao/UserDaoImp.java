package ru.mycomp.preproj231.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mycomp.preproj231.model.User;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImp implements UserDao{
    private final String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
    private final String username = "postgres";
    private final String password = "postgres";

    @Autowired
    SessionFactory sessionFactory;


    @PostConstruct
public void setUserList() {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.save(new User("Tom", 21, "Brand-manager"));
            session.save(new User("David", 19, "HR"));
            session.save(new User("Maria", 23, "Manager"));
            session.save(new User("Sam", 25, "Top-manager"));
            tx1.commit();
        }
        System.out.println(getAllUsers().toString());
    }

    @PreDestroy
    public  void cleanUserList(){
        try(Session session = sessionFactory.openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.delete(new User("Tom", 21, "Brand-manager"));
            session.delete(new User("David", 19, "HR"));
            session.delete(new User("Maria", 23, "Manager"));
            session.delete(new User("Sam", 25, "Top-manager"));
            tx1.commit();
        }
    }

    public void save(User user) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.save(user);
            tx1.commit();
        }
    }

    public List<User> getAllUsers() {
        try(Session session = sessionFactory.openSession()) {
            return (ArrayList<User>) session.createQuery("From User").list();
        }
    }

    public User show(int id) {
        try(Session session = sessionFactory.openSession()) {
            return session.get(User.class, id);
        }
    }

    public void update(int id, User user) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx1 = session.beginTransaction();
            user.setId(id);
            session.update(user);
            tx1.commit();
        }
    }

    public void delete(int id) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.delete(session.get(User.class, id));
            tx1.commit();
        }
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
