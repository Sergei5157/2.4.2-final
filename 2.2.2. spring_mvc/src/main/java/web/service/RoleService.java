package web.service;

import web.models.Role;

import java.util.List;

public interface RoleService {
    Role getOne(long id);
    List<Role> getAll();
}
