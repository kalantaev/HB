package ru.DAO;

import ru.entity.User;

import java.util.List;


public interface UserDAO {
    public List<User> selectSortedByLoginUser();
    public void insertUser(User user);
    public User selectByID(Integer id);
    public User selectByLogin(String login);
    public List<User> selectAllUser();
    public void deleteUserByID(Integer id);
    public void updateUser(User user);
    public void updateLastVisitByID(Integer id);
}
