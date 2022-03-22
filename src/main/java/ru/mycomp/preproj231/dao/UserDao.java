package ru.mycomp.preproj231.dao;

import ru.mycomp.preproj231.model.User;

import java.util.List;

public interface UserDao {

    void setUserList();
    void cleanUserList();
    void save(User user);
    List<User> getAllUsers();
    User show(int id);
    void update(int id, User user);
    void delete(int id);
}
