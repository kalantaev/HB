package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;


public class Main {

    public static void saveUser(User user){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.close();
    }

    public static User getUserById(Integer id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User user = (User) session.get(User.class,id);
        session.close();
        return user;
    }
    public static void addComment(Commentariy com){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(com);
        session.close();
    }

    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        User user = prepareUser();
        session.save(user);

        Commentariy com = prepareComment("Description 1");
        com.setUserAutor(user);
        session.save(com);

        Commentariy com2 = prepareComment("Description 1");
        com2.setUserAutor(user);
        session.save(com2);

        session.getTransaction().commit();
        session.close();

        User user1 = getUserById(2);
        System.out.println(user1.getLogin());
        System.out.println(user1.getDateLastVisit());
    }

    private static Commentariy prepareComment(String desc) {
        Commentariy com = new Commentariy();
        com.setDescription(desc);
        return com;
    }

    private static User prepareUser() {
        User user = new User();
        user.setLogin("login");
        user.setPassword("password");
        user.setDateReg(new Date());
        user.setDateLastVisit(new Date());
        return user;
    }
}
