package dao.implementation;

import Hibernate.HibernateFactory;
import dao.RoleDao;
import entity.Role;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;



public class RoleDaoImpl implements RoleDao {


    @Override
    public Role find(long id) {
        Session session = HibernateFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        Role role = session.get(Role.class,id);
        session.close();
        return role;
    }

    @Override
    public ArrayList<Role> getAll() {
        Session session = HibernateFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from role ");
        ArrayList roles = (ArrayList) query.list();
        session.close();
        return roles;
    }

    @Override
    public Role add(Role o) {
        Session session = HibernateFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return o;
    }


    public Role update(Role o) {
        Session session = HibernateFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        session.find(Role.class,o.getId_role());
        session.merge(o);
        session.getTransaction().commit();
        session.close();
        return o;
    }


    @Override
    public boolean delete(long id) {
        Session session = HibernateFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        Role roleEntity = session.load(Role.class,id);
        session.delete(roleEntity);
        session.getTransaction().commit();
        session.close();
        return true;
    }
}
