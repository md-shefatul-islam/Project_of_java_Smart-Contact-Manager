package com.controller;

import com.dao.ContactDao;
import com.dao.UserDao;
import com.model.Contact;
import com.service.ContactService;
import com.service.SimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/contact")
public class ContactController {

    private UserDao userDao;
    private ContactDao contactDao;
    private SimService simService;
    private ContactService contactService;


    public ContactController() {
    }

    @Autowired
    public ContactController(UserDao userDao, ContactDao contactDao, SimService simService, ContactService contactService) {
        this.userDao = userDao;
        this.contactDao = contactDao;
        this.simService = simService;
        this.contactService = contactService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder)
    {
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @RequestMapping("/home")
    public String home() {
        return "home_user";
    }
    @RequestMapping("/create")
    public String contactForm(Model model, HttpSession session) {

        model.addAttribute("contact",new Contact());
        model.addAttribute("sim",simService.getAll());
        model.addAttribute("id",session.getAttribute("userid"));
        return "addContact";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<Contact> contact = contactDao.getAll();
        model.addAttribute("contact", contact);
        return "contact-list";
    }
//
//    @RequestMapping("/home")
//    public String home(Model model, HttpSession session)
//    {
////        if(session.getAttribute("myUser") != null)
////        {
////            User user = (User) session.getAttribute("myUser");
////            Login login = new Login(user.getName(),user.getPassword());
////            loginDao.update(login);
////        }
//        session.removeAttribute("myUser");
//        model.addAttribute("user",new User());
//        return "home_user";
//    }


    @RequestMapping ("/save")
    public String save(@Valid @ModelAttribute("contact") Contact contact, BindingResult bindingResult, HttpSession session) {
//        session.removeAttribute("msg");
        if (bindingResult.hasErrors()) {
            return "addContact";
        } else {

            session.setAttribute("msg", "success");

            contactDao.create(contact);
               return  "redirect:/contact/create";

        }
    }

    @RequestMapping("update")
    public String update(@RequestParam("id") int id, Model model, HttpSession session)
    {
        if(session.getAttribute("contactid") != null){
            session.removeAttribute("contactid");
        }
        Contact contact=contactDao.get(id);
        session.setAttribute("contactid",id);
        model.addAttribute("contact",contact);
        model.addAttribute("sim",simService.getAll());
        return "contact_update";
    }

    @RequestMapping("saveUpdate")
    public String saveUpdate(@Valid @ModelAttribute("contact") Contact contact, BindingResult bindingResult, HttpSession session){
        if(bindingResult.hasErrors())
        {
            session.setAttribute("sess","failed");
            return "contact_update";
        }
        else {
            int id = (int) session.getAttribute("contactid");
            session.setAttribute("sess","success");
            contactDao.update(contact);
            return "redirect:/contact/list";
        }
    }


    @RequestMapping("delete")
    public String delete(@RequestParam("id") int id){
        contactDao.delete(id);
        return "redirect:/contact/list";
    }

    @RequestMapping("/search")
    public String search(Model model, HttpServletRequest req) {
        String query = req.getParameter("search");
        List<Contact> contact = contactService.getContact(query);
        model.addAttribute("contact", contact);
        return "contact-list";
    }
}
