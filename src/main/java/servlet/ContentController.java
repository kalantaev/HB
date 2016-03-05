package servlet;

import DAO.*;
import entity.Commentariy;
import entity.Content;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import java.util.List;

@Controller
@RequestMapping(value = "/content/")
public class ContentController {

    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("servise.xml");
    private ContentDAO contentDAO = (ContentDAO) ctx.getBean("contentDAO");
    private CommentariyDAO commentariyDAO = (CommentariyDAO) ctx.getBean("commentariyDAO");
    private UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");

    @RequestMapping(method = RequestMethod.GET, params = "id")
    public String getContent(ModelMap model, @RequestParam(value = "id") String id){
        Content content = contentDAO.getContentById(new Integer(id));
        model.addAttribute("content", content);
        List<Commentariy> commentariyList = commentariyDAO.getCommentByContentId(new Integer(id));
        if (commentariyList!=null){
            model.addAttribute("coment", commentariyList);
        }
        return "content";
    }

    @RequestMapping(method = RequestMethod.POST, params = {"id", "description"})
    public String addComment(ModelMap model,
                             @RequestParam(value = "id") String id,
                             @RequestParam(value = "description") String description){
        Commentariy commentariy = new Commentariy();
        commentariy.setContent(contentDAO.getContentById(new Integer(id)));
        commentariy.setDescription(description);
        commentariy.setUserAutor(userDAO.selectByID(1)); //todo после добавления куков
        Cookie cookie = new Cookie("id", id);

        commentariyDAO.saveComment(commentariy);
        Content content = contentDAO.getContentById(new Integer(id));
        model.addAttribute("content", content);
        List<Commentariy> commentariyList = commentariyDAO.getCommentByContentId(new Integer(id));
        if (commentariyList!=null){
            model.addAttribute("coment", commentariyList);
        }
        return "content";
    }
}
