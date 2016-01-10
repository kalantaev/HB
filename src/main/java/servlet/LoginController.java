package servlet;

import DAO.UserDAO;
import DAO.UserDaoImpl;
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
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("servise.xml");
    private UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");
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
            model.addAttribute("errorMessage", "Пользователя с данным логином не существует");
            return "loginpage";
        }
        if (!password.equals(user.getPassword())){
            model.addAttribute("errorMessage", "Вы ввели неверный пароль. Введенный пароль "+password+", пароль из БД "+user.getPassword());

            return "loginpage";
        }
        model.addAttribute("loginMessage", "Вы зашли как "+user.getLogin());
        response.addCookie(new Cookie("id", user.getUserId().toString()));
        return "index";

    }
}
