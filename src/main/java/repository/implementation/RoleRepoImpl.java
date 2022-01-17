package repository.implementation;

import Hibernate.HibernateFactory;
import dao.implementation.RoleDaoImpl;
import entity.Role;

import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.RoleRepo;

import java.util.ArrayList;

public class RoleRepoImpl implements RoleRepo {
    private RoleDaoImpl roleDao = new RoleDaoImpl();
    @Override
    public Role add(Role role) {
        return roleDao.add(role);
    }

    @Override
    public Role find(long id) {
        return roleDao.find(id);
    }

    @Override
    public Role findByName(String roleName) {
        Session session = HibernateFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        Query<Role> query = session.createQuery("from role where name =:name",Role.class);
        query.setParameter("name", roleName);

        Role role = query.getSingleResult();

        session.close();
        return role;
    }

    @Override
    public ArrayList<Role> getAll() {
        return roleDao.getAll();
    }

    @Override
    public Role update(Role role) {
        return roleDao.update(role);
    }

    @Override
    public boolean delete(long id) {
        return roleDao.delete(id);
    }
}
