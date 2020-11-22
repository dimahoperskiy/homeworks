package dao;

import models.Auto;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AutoDao implements Dao<Auto> {

    public AutoDao() {}

    public Auto findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Auto.class, id);
    }

    @Override
    public List<Auto> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return (List<Auto>) session.createQuery("From Auto").list();
    }

    @Override
    public void save(Auto auto) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(auto);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Auto auto) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(auto);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Auto auto) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(auto);
        tx1.commit();
        session.close();
    }
}
