import Hibernate.HibernateFactory;
import dao.implementation.AddressDaoImpl;
import dao.implementation.RoleDaoImpl;
import entity.Role;
import entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.implementation.UserRepoImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UsersTest {
    public static void main(String[] args) {


 /*
        Users user = new Users();
        user.setEmail("Youssef@gmail.com");
        user.setFirst_name("Youssef3");
        user.setLast_name("Diouani3");
        user.setPassword("123456789");











        //Create session factory object
        SessionFactory sessionFactory = HibernateFactory.getInstance().getSession();
        //getting session object from session factory
        Session session = sessionFactory.openSession();
        //getting transaction object from session object
        session.beginTransaction();
Role role = session.find(Role.class,1);
user.setRole(role);
        session.save(user);
        System.out.println("Inserted Successfully");
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        System.out.println("User Object persisted  ");

        System.out.println(user);


    */
        UserRepoImpl user = new UserRepoImpl();
        AddressDaoImpl addressDao = new AddressDaoImpl();
        System.out.println(addressDao.delete(1L));



    }
}
