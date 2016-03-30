package ru.controllers;

import org.springframework.validation.BindingResult;
import ru.DAO.UserDAO;
import ru.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.util.ClassName;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Enumeration;

/**
 * Created by Администратор on 27.03.2016.
 */
@Controller

public class Menu {
    private static final Logger log = Logger.getLogger(ClassName.getClassName());

    @Autowired
    private UserDAO userDAO;
    @RequestMapping(value = "/leftblock", method = RequestMethod.GET)
    public ModelAndView printWelcome(@ModelAttribute("user") User user, HttpServletRequest request, ModelMap mapModel) {
        log.info(request.getContextPath()+request.getServletPath()+request.getPathTranslated());
        Enumeration<String> s = request.getParameterNames();
        String url = "?";
        while (s.hasMoreElements()) {
            String np = s.nextElement();
            if (np.equals("lang")) continue;
            url= url+np+"="+request.getParameter(np)+"&";
        }
                mapModel.addAttribute("url", url);
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("id")) {
                    if (cookie.getValue() != null | !cookie.getValue().equals("0")) {
                        mapModel.addAttribute("user", userDAO.selectByID(new Integer(cookie.getValue())));
                    } else {
                        mapModel.addAttribute("user", new User());
                    }

                }
            }
        }
        return new ModelAndView("leftblock", mapModel);
    }

    @RequestMapping(value = "leftblock", method = RequestMethod.POST)
    public ModelAndView logining(@Valid @ModelAttribute("user") User user, BindingResult result, HttpServletResponse response, HttpServletRequest request) {

        if (result.hasErrors()) {
            return new ModelAndView("index");
        }

        ModelMap mapModel = new ModelMap();

        User userDB = userDAO.selectByLogin(user.getLogin());
        mapModel.addAttribute("user", userDB);

        if (userDB == null) {

            String stringError = "User with this login does not exist";
            mapModel.addAttribute("errorMessage", stringError);
            return new ModelAndView("redirect:/", mapModel);
        }
        else if (!user.getPassword().equals(userDB.getPassword())){
            userDB.setLogin(null);
            String stringError = "You have entered the wrong password";
            mapModel.addAttribute("errorMessage", stringError);
            return new ModelAndView("redirect:/", mapModel);
        }
        response.addCookie(new Cookie("id", userDB.getUserId().toString()));
        return new ModelAndView("redirect:/", mapModel);
    }
    @RequestMapping(value = "/exit", method = RequestMethod.POST)
    public ModelAndView exit(HttpServletResponse response, HttpServletRequest req){
        response.addCookie(new Cookie("id", "0"));

        return new ModelAndView("redirect:/");
    }


}
