package ru.JDBC.DaoJdbcImpl;

import ru.DAO.UserDAO;
import ru.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 29.03.2016.
 */
public class UserDaoJdbcImpl implements UserDAO {
    @Override
    public List<User> selectSortedByLoginUser() {
        return null;
    }

    @Override
    public void insertUser(User user) {

    }

    @Override
    public User selectByID(Integer id) {
        return null;
    }

    @Override
    public User selectByLogin(String login) {
        return null;
    }

    @Override
    public List<User> selectAllUser() {
        Connection connection = new JdbcUtil().getConnection();
        Statement st = null;

        try {
            st =connection.createStatement();
            connection.setAutoCommit(false);
            ResultSet rs =  st.executeQuery("SELECT * FROM user");
            List<User> result = new ArrayList<User>();
            while (rs.next()){
                int id = rs.getInt("user_id");
                String login = rs.getString("login");
                String password = rs.getString("password");
                Date dateReg = rs.getDate("dateReg");
                Date dateLastVizit = rs.getDate("dateLastVizit");
                User user = new User();
                user.setLogin(login);
                user.setPassword(password);
                user.setDateLastVisit(dateLastVizit);
                user.setDateReg(dateReg);
                result.add(user);}
            connection.commit();
            connection.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<User>();
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
