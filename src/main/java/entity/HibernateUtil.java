package entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        if(sessionFactory == null){
            System.out.println("sessionFactory do not inicialization");
            return sessionFactory;
        }else {
            return sessionFactory;

        }
    }

}
