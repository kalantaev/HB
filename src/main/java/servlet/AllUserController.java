package servlet;


import DAO.UserDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/alluser/")
public class AllUserController {

    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("servise.xml");
    private UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");

    @RequestMapping(method = RequestMethod.GET)
    public String getAllUser(ModelMap model){
        model.addAttribute("users", userDAO.selectAllUser());
        return "pagealluser";
    }
}
