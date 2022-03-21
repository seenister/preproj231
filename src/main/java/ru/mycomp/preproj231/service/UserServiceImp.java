package ru.mycomp.preproj231.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mycomp.preproj231.dao.UserDao;
import ru.mycomp.preproj231.model.User;

public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void createDatabase() {
        userDao.createDatabase();

    }
}
