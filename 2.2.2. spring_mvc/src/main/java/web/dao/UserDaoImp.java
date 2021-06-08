package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.Role;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Autowired
    private RoleDao roleDao;

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
        user.setPassword(user.getPassword());
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));
        user.setRoles(roles);
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
        userUpdate.setSalary(user.getSalary());
    }

    @Override
    public User findByUser_login(String name) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.name = :name", User.class);
        query.setParameter("name", name);
        return query.getResultList().stream().findAny().orElse(null);
    }
}

