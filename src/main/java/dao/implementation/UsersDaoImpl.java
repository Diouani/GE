package dao.implementation;

import Hibernate.HibernateFactory;
import dao.UserDao;
import entity.Address;
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
        /*
        Session session = HibernateFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        Users user = session.get(Users.class,id);
        session.close();
       */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionEmployee");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Users user = entityManager.find(Users.class, id);
        entityManager.persist(user);

        entityManager.getTransaction().commit();

        return user;
    }

    @Override
    public ArrayList<Users> getAll() {
        try (Session session = HibernateFactory.getInstance().getSession().openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from Users ");
            ArrayList user = (ArrayList) query.list();

            return user;
        }

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
        session.find(Users.class, user.getUserId());
        Address address = user.getAddress();
        String queryString = "update Users User set User.address=:address where User.userId=:Id";
        Query query = session.createQuery(queryString);
        query.setParameter("address", address);
        query.setParameter("Id", user.getUserId());
        query.executeUpdate();


        session.merge(user);
        session.getTransaction().commit();

        session.close();

        return user;
    }

    @Override
    public boolean delete(long id) {
/*
        Session session = HibernateFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        Users UserEntity = session.load(Users.class,id);
        session.delete(UserEntity);
        session.getTransaction().commit();
        session.close();
*/

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionEmployee");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Users user = entityManager.find(Users.class, id);
        entityManager.remove(user);

        entityManager.getTransaction().commit();

        return true;
    }
}
