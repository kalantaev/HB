package ru.controllers;

import ru.DAO.ContentDAO;
import ru.DAO.UserDAO;
import ru.entity.Content;

import ru.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.util.ClassName;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(value = "/addcontent/")
@SessionAttributes("userId")
public class AddContent {
    private static final Logger log = Logger.getLogger(ClassName.getClassName());
    @Autowired
    private ContentDAO contentDAO;
    @Autowired
    private UserDAO userDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String showAddContentForm(HttpServletRequest request) {
        if(request.getParameter("message")!=null){
            request.setAttribute("message", request.getParameter("message"));
        }
        return "addcontent";
    }


    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView registration(@ModelAttribute Content content, HttpServletRequest request) {
        User user = null;
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("id")) {
                    if (cookie.getValue() != null | !cookie.getValue().equals("0")) {
                      user = userDAO.selectByID(new Integer(cookie.getValue()));
                        content.addUser(user);
                    }

                }
            }
        }

        contentDAO.addContent(content);
        log.info("content id"+content.getContentId());

        return  new ModelAndView("redirect:", "message", "Content " + content.getTitle() + " added");



    }
}
