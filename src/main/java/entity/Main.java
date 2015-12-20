package entity;

import DAO.CommentariyDaoImpl;
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

        User user = prepareUser(1);
        session.save(user);

        User user1 = prepareUser(2);
        session.save(user1);

        Content content = prepareContent(1);
        Set<User> contAutor = new HashSet<User>();
        contAutor.add(user);
        contAutor.add(user1);
        content.setListContentAutor(contAutor);

        session.save(content);


        Commentariy com = prepareComment("Description 1");
        com.setUserAutor(user);
        com.setContent(content);
        session.save(com);

        Commentariy com2 = prepareComment("Description 2");
        com2.setUserAutor(user1);
        com2.setContent(content);
        session.save(com2);

        session.getTransaction().commit();
        session.close();


        List<User> userList = new UserDaoImpl().selectAllUser();
        for (User u:userList){
            System.out.println(u.getLogin());
            System.out.println(u.getPassword());
            System.out.println(u.getUserId());
            System.out.println(u.getDateReg());
//            System.out.println(u.getContentList().get(0).getTitle());
        }
        List<Content> contentSet = new ContentDaoImpl().getAllContent();
        for (Content con: contentSet){
            System.out.println(con.getContentId());
            System.out.println(con.getTitle());
            System.out.println(con.getContentDescription());
        }
        List<Commentariy> commentariyList = new CommentariyDaoImpl().getAllComment();
        for (Commentariy comm:commentariyList){
            System.out.println(comm.getCommentId());
            System.out.println(comm.getDescription());
        }
    }

    private static Commentariy prepareComment(String desc) {
        Commentariy com = new Commentariy();
        com.setDescription(desc);
        return com;
    }

    private static User prepareUser(int n) {
        User user = new User();
        user.setLogin("This login"+n);
        user.setPassword("This password"+ n);
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
