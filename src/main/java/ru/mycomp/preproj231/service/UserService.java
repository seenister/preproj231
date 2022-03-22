package ru.mycomp.preproj231.service;

import ru.mycomp.preproj231.model.User;

import java.util.List;



public interface UserService {

    void setUserList();
    void cleanUserList();
    void save(User user);
    List<User> getAllUsers();
    User show(int id);
    void update(int id, User user);
    void delete(int id);
}
