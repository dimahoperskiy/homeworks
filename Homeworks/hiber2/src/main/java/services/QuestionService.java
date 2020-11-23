package services;

import dao.GroupDao;
import dao.QuestionDao;
import models.Group;
import models.Question;

import java.util.List;

public class QuestionService {

    QuestionDao questionDao = new QuestionDao();

    public QuestionService() {
    }

    public Question findQuestion(int id) {
        return questionDao.findById(id);
    }

    public List<Question> findAllQuestions() {
        return questionDao.getAll();
    }

    public void updateQuestion(Question question) {
        questionDao.update(question);
    }

    public void saveQuestion(Question question) {
        questionDao.save(question);
    }

}
