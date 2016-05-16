package ru.hibernate.hibernateTemplate;

import org.hibernate.mapping.Collection;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import ru.DAO.UserDAO;
import ru.entity.User;

import java.util.List;

/**
 * Created by Kalantaev Alexandr on 15.05.2016.
 */
//@Service
public class UserDAOHibTemp extends HibernateDaoSupport implements UserDAO{
    @Override
    public List<User> selectSortedByLoginUser() {
        return null;
    }

//    public Collection loadProductsByCategory(String category) throws
//            DataAccessException {
//        return this.hibernateTemplate.find("from test.Product product where
//                product.category=?", category);
//    }


    @Override
    public void insertUser(User user) {
        getHibernateTemplate().saveOrUpdate(user);
    }

    @Override
    public User selectByID(Integer id) {
        return getHibernateTemplate().get(User.class, id);
    }

    @Override
    public User selectByLogin(String login) {
        return null;
    }

    @Override
    public List<User> selectAllUser() {
        return null;
    }

    @Override
    public void deleteUserByID(Integer id) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void updateLastVisitByID(Integer id) {

    }
}
