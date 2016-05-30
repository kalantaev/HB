package ru.hibernate.hibernateTemplate;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.mapping.Collection;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import ru.DAO.UserDAO;
import ru.entity.User;
import ru.util.ClassName;

import java.util.Date;
import java.util.List;

/**
 * Created by Kalantaev Alexandr on 15.05.2016.
 */

public class UserDAOHibTemp extends HibernateDaoSupport implements UserDAO{
    private static final Logger log = Logger.getLogger(ClassName.getClassName());


    @Override
    public List<User> selectSortedByLoginUser() {
        return null;
    }


    @Override
    public void insertUser(User user) {
        getHibernateTemplate().save(user);
    }

    @Override
    public User selectByID(Integer id) {
        return getHibernateTemplate().get(User.class, id);
    }

    @Override
    public User selectByLogin(String login) {
        List<User> userList= ((List<User>)getHibernateTemplate().find("from User where login = ?", login));
        log.info("after select");
        if(userList.size()!=0){
        return userList.get(0);}
        else return null;
    }

    @Override
    public List<User> selectAllUser() {
        return (List<User>) getHibernateTemplate().find("from User");
    }

    @Override
    public void deleteUserByID(Integer id) {
        User user = selectByID(id);
        getHibernateTemplate().delete(user);
    }

    @Override
    public void updateUser(User user) {
        getHibernateTemplate().saveOrUpdate(user);
    }

    @Override
    public void updateLastVisitByID(Integer id) {
        User user = selectByID(id);
        user.setDateLastVisit(new Date());
        getHibernateTemplate().saveOrUpdate(user);
    }
}
