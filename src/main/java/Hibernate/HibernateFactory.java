package Hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {



        public SessionFactory getSession(){
            Configuration configuration = new Configuration().configure();
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            return sessionFactory;
        }

        public static HibernateFactory getInstance(){
            return new HibernateFactory();
        }

}
