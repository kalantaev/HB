package entity;

import org.hibernate.Session;

/**
 * Created by Администратор on 09.12.2015.
 */
public class Main {

    public static void saveUser(User user){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(user);
        session.close();
    }

    public static User getUserById(Integer id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User user = (User) session.get(User.class,id);
        session.close();
        return user;
    }

    public static void main(String[] args) {
        User user = new User();
        user.setLogin("login");
        saveUser(user);
        User user1 = getUserById(1);
        System.out.println(user1.getLogin());
    }
}
