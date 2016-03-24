package controllers;

import DAO.ContentDAO;
import entity.Content;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/addcontent/")
@SessionAttributes("userId")
public class AddContentController {

    private ContentDAO contentDAO = (ContentDAO) ServletUtil.getContext().getBean("contentDAO");

    @RequestMapping(method = RequestMethod.GET)
    public String showAddContentForm(ModelMap model) {
        return "addcontent";
    }


    @RequestMapping(method = RequestMethod.POST, params = {"title", "description"})
    public String registration(ModelMap model,
                               @RequestParam(value = "title") String title,
                               @RequestParam(value = "description") String description) {

        Content content = new Content();
        content.setTitle(title);
        content.setContentDescription(description);
        contentDAO.addContent(content);


        model.addAttribute("loginMessage", "Content " + content.getTitle() + " added");
        return "index";


    }
}
