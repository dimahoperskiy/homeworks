package dao;

import models.Group;
import models.Role;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class RoleDao implements Dao<Role> {

    private Role temp;

    public Role findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Role ans = session.get(Role.class, id);
        tx.commit();
        session.close();
        temp = ans;
        return createList();
    }

    public Role createList() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query q = session.createQuery("From User where role = :temp");
        q.setParameter("temp", temp);
        temp.setUserList(new ArrayList<User>(q.list()));
        session.close();
        update(temp);
        return temp;
    }

    @Override
    public List<Role> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return (List<Role>) session.createQuery("From Role").list();
    }

    @Override
    public void save(Role role) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(role);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Role role) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(role);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Role role) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(role);
        tx.commit();
        session.close();
    }
}
