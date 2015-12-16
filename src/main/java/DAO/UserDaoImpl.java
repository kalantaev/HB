package DAO;

import entity.HibernateUtil;
import entity.User;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Администратор on 15.12.2015.
 */
public class UserDaoImpl implements UserDAO {
    public void insertUser(User user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.close();
    }

    public User selectByID(Integer id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User user = (User) session.get(User.class,id);
        session.close();
        return user;
    }

    public User selectByLogin(String login) {
       Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User user = (User) session.createQuery("from User where login = "+login).uniqueResult();
        session.close();
        return user;
    }

    public List<User> selectAllUser() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<User> users = new ArrayList<User>();
        users = (List<User>) session.createQuery("from User ").list();
        session.close();
        return users;
    }

    public void deleteUserByID(Integer id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User user = (User) session.get(User.class,id);
        session.delete(user);
        session.close();
    }

    public void updateUser(User user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(user);
        session.close();
    }

    public void updateLastVisitByID(Integer id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User user = (User) session.get(User.class,id);
        user.setDateLastVisit(new Date());
        session.update(user);
        session.close();

    }
}
