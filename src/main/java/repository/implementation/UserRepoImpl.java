package repository.implementation;

import Hibernate.HibernateFactory;
import dao.implementation.AddressDaoImpl;
import dao.implementation.RoleDaoImpl;
import dao.implementation.UsersDaoImpl;
import entity.Address;
import entity.Role;
import entity.Users;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.UserRepo;

import java.util.ArrayList;

public class UserRepoImpl implements UserRepo {
    UsersDaoImpl userDao = new UsersDaoImpl();

    @Override
    public int login(String Email, String Password) {
        // a mettre au service
        Users user = new UserRepoImpl().findByEmail(Email);
        if(user.getEmail() == null){return 0;}
        return  (user.getPassword().equals(Password)) ? 1 : 2;
    }

    @Override
    public void logout() {

    }

    @Override
    public boolean updatePasswordById(String newPassword, long user_id) {
        Users userUpdated =   userDao.find(user_id);

        userUpdated.setPassword(newPassword);

       userDao.update(userUpdated);
        return true;
    }

    @Override
    public Users find(long id) {
        return userDao.find(id);
    }

    @Override
    public Users findByEmail(String Email) {
        Session session = HibernateFactory.getInstance().getSession().openSession();
        session.beginTransaction();
        Query<Users> query = session.createQuery("from Users where email =:email",Users.class);
        query.setParameter("email", Email);

       Users user = query.getSingleResult();

session.close();

        return user;
    }

    @Override
    public ArrayList<Users> getAll() {
        return userDao.getAll();
    }

    @Override
    public Users add(Users user) {
       if(user.getAddress().getIdAddress() == null){
           Address addressNoId = user.getAddress();
           Address address = new AddressDaoImpl().add(addressNoId);
           user.setAddress(address);
       }
        System.out.println(user);
       if(user.getRole().getName() == null){
          Role role = new RoleDaoImpl().find(user.getRole().getId_role());
          user.setRole(role);
           System.out.println(user);
       }
        return userDao.add(user);

    }

    @Override
    public Users update(Users user) {
        if(user.getRole().getName() == null){
          Role role = new RoleDaoImpl().find(user.getRole().getId_role()) ;
          user.setRole(role);
        }
        return userDao.update(user);
    }

    @Override
    public boolean delete(long id) {
        return userDao.delete(id);
    }
}
