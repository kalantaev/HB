package main;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.DAO.ContentDAO;
import ru.DAO.UserDAO;
import ru.entity.Commentariy;
import ru.entity.Content;
import ru.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.hibernate.DAOHibernateImpl.ContentDaoHibImpl;
import ru.hibernate.HibernateUtil;

import java.util.*;


public class Main {
    private UserDAO userDAO;

    public static void main(String[] args) {


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("servise.xml");
        UserDAO userDAO = (UserDAO) context.getBean("userDAO");
        System.out.println(userDAO);
//        SessionFactory sf = HibernateUtil.getSessionFactory();
//        Session session = sf.openSession();
//        session.beginTransaction();
//
//        ContentDAO contentDAO = new ContentDaoHibImpl();
//        Criteria criteria = session.createCriteria(User.class).addOrder(Order.asc("dateReg"));
//        List<User> list = criteria.list();
//        for (User u: list){
//            System.out.println(u.getLogin());
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

