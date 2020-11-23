package dao;

import models.Group;
import models.Subject;
import models.TestList;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class SubjectDao implements Dao<Subject> {
    private Subject temp;

    public Subject findById(int id) {

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Subject ans = session.get(Subject.class, id);
        tx.commit();
        session.close();
        temp = ans;
        return createList();
    }

    public Subject createList() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query q = session.createQuery("From TestList where subject = :temp");
        q.setParameter("temp", temp);
        temp.setTestListList(new ArrayList<TestList>(q.list()));
        session.close();
        update(temp);
        return temp;
    }


    @Override
    public List<Subject> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Subject> ans = session.createQuery("From Subject").list();
        tx.commit();
        session.close();
        return ans;
    }

    @Override
    public void save(Subject subject) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(subject);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Subject subject) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(subject);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Subject subject) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(subject);
        tx.commit();
        session.close();
    }
}
