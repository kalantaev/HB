package ru.hibernate.DAOHibernateImpl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import ru.DAO.ContentDAO;
import ru.DAO.UserDAO;
import ru.hibernate.HibernateUtil;
import ru.entity.User;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDaoHibImpl implements UserDAO {

    public void insertUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public User selectByID(Integer id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User user = (User) session.get(User.class, id);

        session.close();
        return user;
    }

    public User selectByLogin(String login) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User user = (User) session.createQuery("from User where login = '" + login + "'").uniqueResult();
        session.close();
        return user;
    }

    public List<User> selectSortedByLoginUser() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        Criteria criteria = session.createCriteria(User.class).addOrder(Order.asc("login"));
        List<User> list = criteria.list();
        session.close();
        return list;

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
        User user = (User) session.get(User.class, id);
        session.delete(user);
        session.close();
    }

    public void updateUser(User user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    public void updateLastVisitByID(Integer id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User user = (User) session.get(User.class, id);
//        user.setDateLastVisit(new Date());
        session.update(user);
        session.close();

    }
}
