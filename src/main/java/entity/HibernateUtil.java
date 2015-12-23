package entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        }
        if(sessionFactory == null){
            System.out.println("sessionFactory do not inicialization");
            return sessionFactory;
        }else {
            return sessionFactory;

        }
    }

}
