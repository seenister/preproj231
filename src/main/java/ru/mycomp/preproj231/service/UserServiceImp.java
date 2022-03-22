package ru.mycomp.preproj231.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mycomp.preproj231.dao.UserDao;
import ru.mycomp.preproj231.model.User;

import java.util.List;


@Component
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void setUserList() {
        userDao.setUserList();
    }

    @Override
    public void cleanUserList() {
        userDao.cleanUserList();
    }

    @Override
    public void save(User user) {
        userDao.save(user);

    }

    @Override
    public List<User> getAllUsers() {
       return userDao.getAllUsers();
    }

    @Override
    public User show(int id) {
      return userDao.show(id);
    }

    @Override
    public void update(int id, User user) {
        userDao.update(id, user);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);

    }
}
