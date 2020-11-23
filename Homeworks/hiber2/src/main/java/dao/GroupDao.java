package dao;

import models.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class GroupDao implements Dao<Group> {

    private Group temp;

    public Group findById(int id) {

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Group ans = session.get(Group.class, id);
        tx.commit();
        session.close();
        temp = ans;
        return createList();
    }

    public Group createList() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query q = session.createQuery("From User where group = :temp");
        q.setParameter("temp", temp);
        temp.setUserList(new ArrayList<User>(q.list()));
        session.close();
        update(temp);
        return temp;
    }


    @Override
    public List<Group> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Group> ans = session.createQuery("From Group").list();
        tx.commit();
        session.close();
        return ans;
    }

    @Override
    public void save(Group group) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(group);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Group group) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(group);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Group group) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(group);
        tx.commit();
        session.close();
    }

}
