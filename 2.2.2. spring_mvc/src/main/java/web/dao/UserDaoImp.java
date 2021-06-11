package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getOne(long id) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id = :id", User.class);
        query.setParameter("id", id);
        return query.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void remove(long id) {
        User user = getOne(id);
        entityManager.remove(user);
    }

    @Override
    public void update(long id, User user) {
        User userUpdate = getOne(id);
        userUpdate.setName(user.getName());
        userUpdate.setAge(user.getAge());
        userUpdate.setPassword(user.getPassword());
        userUpdate.setRoles(user.getRoles());
        userUpdate.setSalary(user.getSalary());
    }

    @Override
    public User findByUser_login(String name) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.name = :name", User.class);
        query.setParameter("name", name);
        return query.getResultList().stream().findAny().orElse(null);
    }
}

