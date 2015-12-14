package entity;

import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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

    public static void main(String[] args) {
        User user = new User();
        user.setLogin("login");
        user.setPassword("password");
        Commentariy com = new Commentariy();
        com.setUserAutor(user);
        com.setDescription("Description 1");
        Commentariy com2 = new Commentariy();
        com2.setUserAutor(user);
        com2.setDescription("Description 2");
        List<Commentariy> commentariys = new ArrayList<Commentariy>();
        commentariys.add(com);
        commentariys.add(com2);
        user.setCommentariyList(commentariys);
        user.setDateReg(new Date());
        user.setDateLastVisit(new Date());
        saveUser(user);
        User user1 = getUserById(1);
        System.out.println(user1.getLogin());
        System.out.println(user1.getDateLastVisit());
    }
}
