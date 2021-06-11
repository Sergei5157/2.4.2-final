package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.RoleDao;
import web.models.Role;

@Service
public class RoleServiceImp implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public Role getOne(long id) {
        return roleDao.getOne(id);
    }
}
