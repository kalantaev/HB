package entity;

import DAO.ContentDaoImpl;
import DAO.UserDaoImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.*;


public class Main {







    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        User user = prepareUser();
        user.setContentList(null);
        session.save(user);

        Content content = prepareContent(1);
        Set<User> contAutor = new HashSet<User>();
        contAutor.add(user);
        content.setListContentAutor(contAutor);
        session.save(content);


        Commentariy com = prepareComment("Description 1");
        com.setUserAutor(user);
        com.setContent(content);
        session.save(com);

        Commentariy com2 = prepareComment("Description 2");
        com2.setUserAutor(user);
        com2.setContent(content);
        session.save(com2);

        session.getTransaction().commit();
        session.close();

        Set<Content> contentSet = new HashSet<Content>();
        contentSet.add(content);
        user.setContentList(contentSet);
        new UserDaoImpl().updateUser(user);


        User userBD = new UserDaoImpl().selectByID(1);

        System.out.println(new UserDaoImpl().selectAllUser().get(0).getLogin());
        System.out.println(userBD.getPassword());

        userBD.setContentList(new ContentDaoImpl().getAllContent());
        System.out.println(userBD.getContentList());


    }

    private static Commentariy prepareComment(String desc) {
        Commentariy com = new Commentariy();
        com.setDescription(desc);
        return com;
    }

    private static User prepareUser() {
        User user = new User();
        user.setLogin("This login");
        user.setPassword("This password");
        user.setDateReg(new Date());
        user.setDateLastVisit(new Date());
        return user;
    }

    private  static Content prepareContent(int n){
        Content content = new Content();
        content.setTitle("This content title #" + n);
        content.setContentDescription("This content description #"+n);
        return content;
    }
}
