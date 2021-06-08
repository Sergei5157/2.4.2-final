package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.models.User;


import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User getOne(long id) {
        return userDao.getOne(id);
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void remove(long id) {
        userDao.remove(id);
    }

    @Override
    public void update(long id, User user) {
        userDao.update(id, user);
    }

    @Override
    public User findByUser_login(String name) {
        return userDao.findByUser_login(name);
    }
}
