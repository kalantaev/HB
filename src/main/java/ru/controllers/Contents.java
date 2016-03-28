package ru.controllers;


import ru.DAO.CommentariyDAO;
import ru.DAO.ContentDAO;
import ru.DAO.UserDAO;
import ru.entity.Commentariy;
import ru.entity.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/content/")
public class Contents {

    @Autowired
    private ContentDAO contentDAO;
    @Autowired
    private CommentariyDAO commentariyDAO;
    @Autowired
    private UserDAO userDAO;

    @RequestMapping(method = RequestMethod.GET, params = "id")
    public String getContent(ModelMap model, @RequestParam(value = "id") String id) {
        Content content = contentDAO.getContentById(new Integer(id));
        model.addAttribute("content", content);
        List<Commentariy> commentariyList = commentariyDAO.getCommentByContentId(new Integer(id));
        if (commentariyList != null) {
            model.addAttribute("coment", commentariyList);
        }
        return "content";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addComment(@ModelAttribute Commentariy commentariy,HttpServletRequest request) {
        int idContent = Integer.valueOf(request.getParameter("id"));
        commentariy.setContent(contentDAO.getContentById(idContent));
        commentariy.setUserAutor(userDAO.selectByID(1)); //todo после добавления куков
        commentariyDAO.saveComment(commentariy);
        Content content = contentDAO.getContentById(idContent);
        ModelMap map = new ModelMap();
        map.addAttribute("content", content);
        List<Commentariy> commentariyList = commentariyDAO.getCommentByContentId(new Integer(idContent));
        if (commentariyList != null) {
            map.addAttribute("coment", commentariyList);
        }
        return "redirect:?id="+idContent;
    }
}
