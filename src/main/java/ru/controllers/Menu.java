package ru.controllers;

import DAO.UserDAO;
import entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
    public ModelAndView printWelcome(HttpServletRequest request, ModelMap mapModel) {
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
    public ModelAndView logining(@ModelAttribute("user") User userForm, HttpServletResponse response, HttpServletRequest request) {
        log.info(request.getContextPath());
        ModelMap mapModel = new ModelMap();

        Enumeration<String> s = request.getParameterNames();
        String url = "?";
        while (s.hasMoreElements()) {
            String np = s.nextElement();
            if (np.equals("lang")) continue;
            url= url+np+"="+request.getParameter(np)+"&";
        }
        mapModel.addAttribute("url", url);

        User userDB = userDAO.selectByLogin(userForm.getLogin());
        if (userDB == null) {

            String stringError = "User with this login does not exist";
            mapModel.addAttribute("errorMessage", stringError);
            return new ModelAndView("leftblock", mapModel);
        }
        else if (!userForm.getPassword().equals(userDB.getPassword())){
            String stringError = "You have entered the wrong password";
            mapModel.addAttribute("errorMessage", stringError);
            return new ModelAndView("/leftblock", mapModel);
        }
        response.addCookie(new Cookie("id", userDB.getUserId().toString()));
        return new ModelAndView("leftblock", mapModel);
    }
    @RequestMapping(value = "/exit", method = RequestMethod.POST)
    public ModelAndView exit(HttpServletResponse response, HttpServletRequest req){
        response.addCookie(new Cookie("id", "0"));

        return new ModelAndView("leftblock");
    }


}
