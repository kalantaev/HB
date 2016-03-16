package servlet;


import DAO.UserDAO;
import entity.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping(value = "/registration/")

public class RegistrationController {
    ClassPathXmlApplicationContext ctx = ServletUtil.getContext();
    private UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");
    @RequestMapping(method = RequestMethod.GET)
    public String getRegForm(ModelMap model){
        return "registration";
    }
    @RequestMapping(method = RequestMethod.POST, params = {"login", "password"})
    public String registration (ModelMap model,
                           @RequestParam(value = "login") String login,
                           @RequestParam(value = "password") String password) {
        User userBD =userDAO.selectByLogin(login);
        if(userBD!=null){
            model.addAttribute("errorMessage", "User with this login already exists");
            return "registration";
        }
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setDateReg(new Date());
        user.setDateLastVisit(new Date());
        userDAO.insertUser(user);


        model.addAttribute("loginMessage", "The account with the username "+user.getLogin()+" created");
        return "index";

    }
}
