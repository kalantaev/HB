package servlet;

import DAO.UserDAO;
import entity.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/login/")

public class LoginController {

    private UserDAO userDAO = (UserDAO) ServletUtil.getContext().getBean("userDAO");
    @RequestMapping(method = RequestMethod.GET)
    public String showLoginForm(ModelMap model) {
        return "loginpage";
    }

    @RequestMapping(method = RequestMethod.POST, params = {"login", "password"})
    public String Logining(ModelMap model,
                           HttpServletResponse response,
                           @RequestParam(value = "login") String login,
                           @RequestParam(value = "password") String password) {
        User user = userDAO.selectByLogin(login);
        if(user==null){
            model.addAttribute("errorMessage", "User with this login does not exist");
            return "loginpage";
        }
        if (!password.equals(user.getPassword())){
            model.addAttribute("errorMessage", "You have entered the wrong password. The password entered "+password+", Password from the database "+user.getPassword());

            return "loginpage";
        }
        model.addAttribute("loginMessage", "You are logged in as "+user.getLogin());
        response.addCookie(new Cookie("id", user.getUserId().toString()));
        return "index";

    }
}
