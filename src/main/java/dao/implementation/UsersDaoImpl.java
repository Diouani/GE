package dao.implementation;

import Hibernate.HibernateFactory;
import dao.UserDao;
import entity.Role;
import entity.Users;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class UsersDaoImpl implements UserDao {
    @Override
    public Users find(long id) {
        Session session = HibernateFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        Users user = session.get(Users.class,id);
        session.close();
        return user;
    }

    @Override
    public ArrayList<Users> getAll() {
        Session session = HibernateFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Users ");
        ArrayList user = (ArrayList) query.list();
        session.close();
        return user;
    }

    @Override
    public Users add(Users user) {
        Session session = HibernateFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return user;

    }

    @Override
    public Users update(Users user) {
        Session session = HibernateFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        session.find(Users.class,user.getUserId());
        session.merge(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public boolean delete(long id) {

        Session session = HibernateFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        Users UserEntity = session.load(Users.class,id);
        session.delete(UserEntity);
        session.getTransaction().commit();
        session.close();
        return true;
    }
}
