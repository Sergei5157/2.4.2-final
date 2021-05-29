package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();

    User getOne(long id);

    void add(User user);

    void remove(long id);

    void update(long id, User user);
}
