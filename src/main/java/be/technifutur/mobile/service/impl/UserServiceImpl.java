package be.technifutur.mobile.service.impl;

import be.technifutur.mobile.dao.UserDao;
import be.technifutur.mobile.domain.User;
import be.technifutur.mobile.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDao();

    @Override
    public User register(String username, String password) {

        User found = userDao.findByUsername(username);
        if (found != null) {
            return null;
        } else {
            return userDao.insert(new User(username, password));
        }
    }

    @Override
    public boolean login(String username, String password) {

        User found = userDao.findByUsername(username);

        if (found != null && found.getPassword().equals(password)) {
            return true;
        }

        return false;
    }
}
