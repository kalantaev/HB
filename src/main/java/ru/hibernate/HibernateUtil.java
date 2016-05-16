package ru.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){ //todo try catch


        if(sessionFactory == null){
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("servise.xml");
            sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
//            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        }
        if(sessionFactory == null){
            System.out.println("sessionFactory do not inicialization");
            return sessionFactory;
        }else {
            return sessionFactory;

        }
    }

}
