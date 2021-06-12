package web.dao;

import web.models.Role;

import java.util.List;


public interface RoleDao {
    Role getOne(long id);
    List<Role> getAll();
}
