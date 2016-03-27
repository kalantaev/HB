package ru.controllers;

import DAO.UserDAO;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by Администратор on 27.03.2016.
 */
@Controller

public class Menu {
    @Autowired
    private UserDAO userDAO;
    @RequestMapping(value = "/leftblock", method = RequestMethod.GET)
    public ModelAndView printWelcome(HttpServletRequest request, ModelMap mapModel) {

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

    @RequestMapping(value = "/leftblock", method = RequestMethod.POST)
    public ModelAndView logining(@Valid @ModelAttribute("user") User userForm, BindingResult bindingResult, HttpServletResponse response) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("leftblock");
        }
        User userDB = userDAO.selectByLogin(userForm.getLogin());
        if (userDB == null) {
            String stringError = "User with this login does not exist";
            return new ModelAndView("leftblock", "errorMessage", stringError);
        }
        if (!userForm.getPassword().equals(userDB.getPassword())) {
            String stringError = "You have entered the wrong password";
            return new ModelAndView("leftblock", "errorMessage", stringError);
        }
        response.addCookie(new Cookie("id", userDB.getUserId().toString()));
        return new ModelAndView("leftblock");
    }
    @RequestMapping(value = "/exit", method = RequestMethod.POST)
    public ModelAndView exit(HttpServletResponse response, HttpServletRequest req){
        response.addCookie(new Cookie("id", "0"));
        response.addCookie(new Cookie("pathii", req.getContextPath()));
        return new ModelAndView("leftblock");
    }
}
