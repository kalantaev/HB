package servlet;


import DAO.UserDaoImpl;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        List<User> userList = new UserDaoImpl().selectAllUser();
        model.addAttribute("users", userList);
        model.addAttribute("message", "Hello world!");
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST, params = {"login", "password"})
    public String printWelcome2(ModelMap model, @RequestParam(value = "login") String log, @RequestParam(value = "password") String pass) {
        if (log!=null){
            model.addAttribute("log", log);
            model.addAttribute("pas", pass);
        }
        model.addAttribute("message", "Hello world!");
        return "index";
    }
}