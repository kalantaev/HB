package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){ //todo try catch
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
