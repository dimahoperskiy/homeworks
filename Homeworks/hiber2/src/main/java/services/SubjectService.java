package services;

import dao.SubjectDao;
import models.Group;
import models.Subject;

import java.util.List;

public class SubjectService {
    SubjectDao subjectDao = new SubjectDao();

    public SubjectService() {
    }

    public Subject findSubject(int id) {
        return subjectDao.findById(id);
    }

    public List<Subject> findAllSubjects() {
        return subjectDao.getAll();
    }

    public void updateSubject(Subject subject) {
        subjectDao.update(subject);
    }

    public void saveSubject(Subject subject) {
        subjectDao.save(subject);
    }

    public void deleteSubject(Subject subject) {
        subjectDao.delete(subject);
    }
}
