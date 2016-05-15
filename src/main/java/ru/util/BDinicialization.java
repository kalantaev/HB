package ru.util;

import org.springframework.beans.factory.annotation.Autowired;
import ru.DAO.CommentariyDAO;
import ru.DAO.ContentDAO;
import ru.DAO.UserDAO;
import ru.entity.Commentariy;
import ru.entity.Content;
import ru.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kalantaev Alexandr on 15.05.2016.
 */
public class BDinicialization {
    @Autowired
    private ContentDAO contentDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private CommentariyDAO commentariyDAO;

    BDinicialization(){
//        inicialization();

    }

    public void inicialization(){
        User user = new User();
        user.setLogin("login");
        user.setPassword("password");


        Content content = new Content();
        content.setTitle("This example of display content");
        content.setContentDescription("This example of display content . The system was originally registered as a user with the login \"login\" and password \"password\"");
        List<User> userList = new ArrayList<User>();
        userList.add(user);
        content.setListContentAutor(userList);
        List<Content> contentList = new ArrayList<Content>();
        contentList.add(content);
        user.setContentList(contentList);

        Commentariy commentariy = new Commentariy();
        commentariy.setContent(content);
        commentariy.setUserAutor(user);
        commentariy.setDescription("This example of display comment");

        userDAO.insertUser(user);
        contentDAO.addContent(content);
        commentariyDAO.saveComment(commentariy);


    }
}
