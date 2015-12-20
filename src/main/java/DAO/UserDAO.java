package DAO;

import entity.User;

import java.util.List;

/**
 * Created by ������������� on 15.12.2015.
 */
public interface UserDAO {
    public void insertUser(User user);
    public User selectByID(Integer id);
    public User selectByLogin(String login);
    public List<User> selectAllUser();
    public void deleteUserByID(Integer id);
    public void updateUser(User user);
    public void updateLastVisitByID(Integer id);
}