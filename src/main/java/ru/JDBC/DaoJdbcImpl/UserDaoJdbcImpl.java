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
        Connection connection = new JdbcUtil().getConnection();
        Statement st = null;
        ResultSet rs = null;
        User user = new User();
        try {
            st = connection.createStatement();
            connection.setAutoCommit(false);
            rs = st.executeQuery("SELECT * FROM user WHERE user_id =" + id);
            while (rs.next()) {
                user.setUserId(rs.getInt("user_id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setDateReg(rs.getDate("dateReg"));
                user.setDateLastVisit(rs.getDate("dateLastVizit"));
            }
            connection.commit();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
                connection.close();
            } catch (SQLException e) {
                //NOP
            }

        }
        return user;
    }

    @Override
    public User selectByLogin(String login) {
        return null;
    }

    @Override
    public List<User> selectAllUser() {
        Connection connection = new JdbcUtil().getConnection();
        Statement st = null;
        ResultSet rs = null;
        List<User> result = new ArrayList<User>();
        try {
            st = connection.createStatement();
            connection.setAutoCommit(false);
            rs = st.executeQuery("SELECT * FROM user");
            while (rs.next()) {
                int id = rs.getInt("user_id");
                String login = rs.getString("login");
                String password = rs.getString("password");
                Date dateReg = rs.getDate("dateReg");
                Date dateLastVizit = rs.getDate("dateLastVizit");
                User user = new User();
                user.setUserId(id);
                user.setLogin(login);
                user.setPassword(password);
                user.setDateLastVisit(dateLastVizit);
                user.setDateReg(dateReg);
                result.add(user);
            }
            connection.commit();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
                connection.close();
            } catch (SQLException e) {
                //NOP
            }

        }
        return result;
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
