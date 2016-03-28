package ru.controllers;


import ru.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/alluser/")
public class AllUser {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllUser(ModelMap model){
        model.addAttribute("users", userDAO.selectAllUser());
        return "pagealluser";
    }
}
