package com.controller;

import com.dao.LoginDao;
import com.dao.UserDao;
import com.model.Login;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@Scope("session")
@RequestMapping("/login")
public class LoginController {

    private LoginDao loginDao;
    private UserDao userDao;


    public LoginController() {
    }

    @Autowired
    public LoginController(LoginDao loginDao,UserDao userDao) {
        this.loginDao = loginDao;
        this.userDao = userDao;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder)
    {
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @RequestMapping("login")
    public String login(Model model)
    {
        model.addAttribute("login",new Login());
        return "login";
    }
    @RequestMapping("verify")
    public String validate(@Valid @ModelAttribute("login")Login login, BindingResult bindingResult, HttpSession session)
    {
        if(bindingResult.hasErrors())
        {
            return "login";
        }
        else
        {
            session.setAttribute("error","success");
            String name = login.getName();
            String pass = login.getPassword();

            List<Login> logins = loginDao.getAll();
            for (Login myLogin : logins){
                if(myLogin.getName().equals(name) && myLogin.getPassword().equals(pass))
                {
                    List<User> users = userDao.getAll();
                    for (User user : users){
                        if(user.getName().equals(name) && user.getPassword().equals(pass)){
                            session.setAttribute("loginUser", user);
                            session.setAttribute("username", name);
                            session.setAttribute("userid", user.getId());
                            session.setAttribute("flag", "1");
                            return "redirect:/contact/home";
//                            return "redirect:/email/sendEmail";
                        }
                    }
                }
            }
            session.setAttribute("error","failed");
            return "login";
        }
    }

    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginUser");
        session.removeAttribute("username");
        session.removeAttribute("userid");
        session.removeAttribute("error");
        session.removeAttribute("error");
        session.removeAttribute("valid");
        session.setAttribute("flag", "2");
        return "redirect:/login/login";
    }
}
