package services;

import dao.RoleDao;
import models.Group;
import models.Role;

import java.util.List;

public class RoleService {

    RoleDao roleDao = new RoleDao();

    public RoleService() {
    }

    public Role findRole(int id) {
        return roleDao.findById(id);
    }

    public List<Role> findAllRoles() {
        return roleDao.getAll();
    }

    public void updateRole(Role role) {
        roleDao.update(role);
    }

    public void saveRole(Role role) {
        roleDao.save(role);
    }

    public void deleteRole(Role role) {
        roleDao.delete(role);
    }
}
