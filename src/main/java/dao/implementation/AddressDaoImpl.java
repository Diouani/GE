package dao.implementation;

import Hibernate.HibernateFactory;
import dao.AddressDao;
import entity.Address;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class AddressDaoImpl implements AddressDao {
    @Override
    public Address add(Address address) {
        Session session = HibernateFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        session.save(address);
        session.getTransaction().commit();
        session.close();
        return address;
    }

    @Override
    public Address find(long id) {
        Session session = HibernateFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        Address address = session.get(Address.class,id);
        session.close();
        return address;

    }

    @Override
    public ArrayList<Address> getAll() {
        Session session = HibernateFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Users ");
        ArrayList<Address> address = (ArrayList<Address>) query.list();
        session.close();
        return address;
    }

    @Override
    public Address update(Address address) {
        Session session = HibernateFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        session.find(Address.class,address.getIdAddress());
        session.merge(address);
        session.getTransaction().commit();
        session.close();
        return address;
    }

    @Override
    public boolean delete(long id) {
        Session session = HibernateFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        Address addressEntity = session.load(Address.class,id);
        session.delete(addressEntity);
        session.getTransaction().commit();
        session.close();
        return true;
    }
}
