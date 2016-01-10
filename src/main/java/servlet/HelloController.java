package servlet;


import DAO.ContentDAO;
import DAO.UserDAO;
import entity.Content;
import entity.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class HelloController {
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("servise.xml");
    private ContentDAO contentDAO = (ContentDAO) ctx.getBean("contentDAO");
    private UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model, HttpServletRequest request) {
        List<Content> contents = contentDAO.getAllContent();
        model.addAttribute("contents", contents);
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id")) {
                    model.addAttribute("cookie", cookie.getValue());
                    if (cookie.getValue() != null| !cookie.getValue().equals("0")) {
                        User user = userDAO.selectByID(new Integer(cookie.getValue()));
                        model.addAttribute("user", user);
                    }

                }
            }
        }
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST, params = {"login", "password", "exit"})
    public String Logining(ModelMap model,
                           HttpServletResponse response,
                           @RequestParam(value = "login") String login,
                           @RequestParam(value = "password") String password,
                           @RequestParam(value = "exit") String exit) {
        int ex = new Integer(exit);
        if (ex==0) {
            User user = userDAO.selectByLogin(login);
            if (user == null) {
                model.addAttribute("errorMessage", "Пользователя с данным логином не существует");
                return "loginpage";
            }
            if (!password.equals(user.getPassword())) {
                model.addAttribute("errorMessage", "Вы ввели неверный пароль. Введенный пароль " + password + ", пароль из БД " + user.getPassword());

                return "loginpage";
            }
            List<Content> contents = contentDAO.getAllContent();
            model.addAttribute("contents", contents);
            model.addAttribute("loginMessage", "Вы зашли как " + user.getLogin());
            response.addCookie(new Cookie("id", user.getUserId().toString()));
            return "index";
        } else {
            List<Content> contents = contentDAO.getAllContent();
            model.addAttribute("contents", contents);
            response.addCookie(new Cookie("id", "0"));

            return "index";

        }

    }
}