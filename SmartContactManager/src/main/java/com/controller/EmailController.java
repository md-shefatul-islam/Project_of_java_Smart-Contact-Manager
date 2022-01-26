package com.controller;

import com.dao.ContactDao;
import com.model.Contact;
import com.model.Email;
import com.model.User;
import com.service.ContactAppEmailServiceImpl;
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

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/email")
public class EmailController {

    private ContactAppEmailServiceImpl contactAppEmailService;
    private ContactDao contactDao;

    public EmailController() {
    }

    @Autowired
    public EmailController(ContactAppEmailServiceImpl contactAppEmailService, ContactDao contactDao) {
        this.contactAppEmailService = contactAppEmailService;
        this.contactDao = contactDao;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder)
    {
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @RequestMapping("/sendEmail")
    public String sendEmail(Model model, HttpSession session){

        model.addAttribute("email",new Email());

        return "send-email-page";
    }

    @RequestMapping("/send")
    public String processEmail(@Valid @ModelAttribute("email") Email email, BindingResult bindingResult, HttpSession session){

        if (bindingResult.hasErrors()) {
            return "send-email-page";
        } else {
            if(session.getAttribute("email1") != null){
                session.removeAttribute("email1");
            }
            session.setAttribute("email",email.getUserEmail());
            return "redirect:/email/email-list";

        }
    }

    @RequestMapping("/email-list")
    public String list(Model model) {
        List<Contact> contact = contactDao.getAll();
        model.addAttribute("contact", contact);
        return "email_list";
    }

    @RequestMapping("valueadd")
    public String update(@RequestParam("name") String name,@RequestParam("phone") String phone, Model model, HttpSession session)
    {
        session.setAttribute("email1", "send");
//        System.out.println(name);
//        System.out.println(phone);
        User user = (User) session.getAttribute("loginUser");
        String email = (String) session.getAttribute("email");
        contactAppEmailService.sendEmail(user.getName(),email,name,phone);
        return "redirect:/email/sendEmail";
    }
}
