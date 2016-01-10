package servlet;


import DAO.UserDAO;
import DAO.UserDaoImpl;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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
