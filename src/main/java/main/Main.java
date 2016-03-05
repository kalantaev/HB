package main;

import DAO.CommentariyDaoImpl;
import DAO.ContentDaoImpl;
import DAO.UserDAO;
import DAO.UserDaoImpl;
import entity.Commentariy;
import entity.Content;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.*;


public class Main {
    private UserDAO userDAO;

    public static void main(String[] args) {

//        SessionFactory sf = HibernateUtil.getSessionFactory();
//        Session session = sf.openSession();
//        session.beginTransaction();
////
//        User user = prepareUser(1);
//        session.save(user);
//
//        User user1 = prepareUser(2);
//        session.save(user1);
//
//        Content content = prepareContent(1);
//        List<User> contAutor = new ArrayList<User>();
//        contAutor.add(user);
//        contAutor.add(user1);
//        content.setListContentAutor(contAutor);
//
//        session.save(content);
//
//
//        Commentariy com = prepareComment("Description 1");
//        com.setUserAutor(user);
//        com.setContent(content);
//        session.save(com);
//
//        Commentariy com2 = prepareComment("Description 2");
//        com2.setUserAutor(user1);
//        com2.setContent(content);
//        session.save(com2);
////
//        session.getTransaction().commit();
//        session.close();
            List<Commentariy> commentariys = new CommentariyDaoImpl().getCommentByContentId(1);
            for (Commentariy c: commentariys){
                System.out.println(c.getDescription());
                System.out.println(c.getUserAutor().getLogin());
            }
//       List<User> users = new UserDaoImpl().selectAllUser();
//        System.out.println(users.get(0).getLogin());
//        System.out.println(users.get(0).getUserId());
//        System.out.println(users.get(0).getCommentariyList().get(0).getDescription());
//        System.out.println(user2.getLogin());
//        System.out.println(user2.getCommentariyList().get(0).getDescription());
//        List<Content> contentSet =  user2.getContentList();
//
//        Commentariy commentariy = new CommentariyDaoImpl().getCommentById(1);
//        System.out.println(commentariy.getDescription());
//        System.out.println(commentariy.getContent().getTitle());
//        System.out.println(commentariy.getUserAutor().getLogin());
//
//        Content content1 = new ContentDaoImpl().getContentById(1);
//        System.out.println(content1.getTitle());
//        System.out.println(content1.getCommentariyList().get(0).getUserAutor().getLogin());
//        List<User> userSet = content1.getListContentAutor();
//        for (User user3 : userSet) {
//            System.out.println(user3.getLogin());
//        }

    }

    private static Commentariy prepareComment(String desc) {
        Commentariy com = new Commentariy();
        com.setDescription(desc);
        return com;
    }

    private static User prepareUser(int n) {
        User user = new User();
        user.setLogin("login"+n);
        user.setPassword("password"+ n);
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

