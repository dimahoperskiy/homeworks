package services;

import dao.GroupDao;
import models.Group;

import java.util.List;

public class GroupService {

    GroupDao groupDao = new GroupDao();

    public GroupService() {
    }

    public Group findGroup(int id) {
        return groupDao.findById(id);
    }

    public List<Group> findAllGroups() {
        return groupDao.getAll();
    }

    public void updateGroup(Group group) {
        groupDao.update(group);
    }

    public void saveGroup(Group group) {
        groupDao.save(group);
    }

    public void deleteGroup(Group group) {
        groupDao.delete(group);
    }
}
