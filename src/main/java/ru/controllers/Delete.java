package ru.controllers;

import DAO.CommentariyDAO;
import DAO.ContentDAO;
import org.apache.log4j.Logger;
import org.hibernate.SessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.util.ClassName;

import javax.servlet.http.HttpServletRequest;

@Controller

public class Delete {
    @Autowired
    ContentDAO contentDAO;
    @Autowired
    CommentariyDAO commentariyDAO;
    private static final Logger log = Logger.getLogger(ClassName.getClassName());

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(HttpServletRequest request) {
        //Todo
        try {
            if (request.getParameter("id_content") != null) {
                contentDAO.remuveContentById(Integer.valueOf(request.getParameter("id_content")));
            }
            else if(request.getParameter("id_coment")!=null){
                request.setAttribute("id", request.getParameter("id"));
                commentariyDAO.deleteCommentById(Integer.valueOf(request.getParameter("id_coment")));

            }
        } catch (SessionException e) {
        }
        if (request.getParameter("id_content") == null) {
        return "redirect:/content/?id="+request.getParameter("id");}
        else {
        return "redirect:/";}
    }

}
