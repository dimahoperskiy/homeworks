package dao;

import models.Answer;
import models.Question;
import models.Role;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class QuestionDao implements Dao<Question> {
    private Question temp;

    public Question findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Question ans = session.get(Question.class, id);
        tx.commit();
        session.close();
        temp = ans;
        return createList();
    }

    public Question createList() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query q = session.createQuery("From Answer where question = :temp");
        q.setParameter("temp", temp);
        temp.setAnswerList(new ArrayList<Answer>(q.list()));
        session.close();
        update(temp);
        return temp;
    }

    @Override
    public List<Question> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return (List<Question>) session.createQuery("From Question").list();
    }

    @Override
    public void save(Question question) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(question);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Question question) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(question);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Question question) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(question);
        tx.commit();
        session.close();
    }
}
