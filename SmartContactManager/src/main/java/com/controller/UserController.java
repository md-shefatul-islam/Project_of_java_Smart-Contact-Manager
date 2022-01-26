package com.controller;

import com.dao.LoginDao;
import com.dao.UserDao;
import com.model.Login;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserDao userDao;
    private LoginDao loginDao;


    public UserController() {
    }

    @Autowired
    public UserController(UserDao userDao, LoginDao loginDao) {
        this.userDao = userDao;
        this.loginDao = loginDao;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder)
    {
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @RequestMapping ("/home")
    public String update(){
        return "home_user";
    }



//    @RequestMapping("/list")
//    public String list(Model model) {
//        List<User> users = userDao.getAll();
//        model.addAttribute("users", users);
//        return "user-list";
//    }

    @RequestMapping ("/profile")
    public String update(Model model, HttpSession session){
        Integer id = (Integer) session.getAttribute("userid");
        User user=userDao.getById(id);
        model.addAttribute("user",user);
        return "user_profile";
    }

    @RequestMapping("/create")
    public String create(Model model, HttpSession session)
    {
        if(session.getAttribute("myUser") != null)
        {
            User user = (User) session.getAttribute("myUser");
            Login login = new Login(user.getName(),user.getPassword());
            loginDao.update(login);
        }
        session.removeAttribute("myUser");
        model.addAttribute("user",new User());
        return "signup";
    }

//    @RequestMapping ("/update")
//    public String update(@RequestParam("id") int id, Model model){
//        User user=userDao.getById(id);
//        model.addAttribute("user",user);
//        return "user-update";
//    }

    @RequestMapping ("/enter")
    public String enter(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,HttpSession session) {
        session.removeAttribute("msg");
        if (bindingResult.hasErrors()) {
            return "signup";
        } else {

            session.setAttribute("myUser", user);

            userDao.create(user);
            return  "redirect:/user/create";

        }
    }

    @RequestMapping ("/saveUpdate")
    public String saveUpdate(@Valid @ModelAttribute("user") User user,BindingResult bindingResult, HttpSession session)
    {
        if(bindingResult.hasErrors())
        {
            session.setAttribute("valid", "failed");
            return "user_profile";
        }
        else
        {
            int id = (int) session.getAttribute("userid");
            user.setId(id);
            userDao.update(user);
            session.setAttribute("valid", "success");
            return "user_profile";
        }

    }


    @RequestMapping("delete")
    public String delete(HttpSession session){
        int id = (int) session.getAttribute("userid");
        userDao.delete(id);
        return "redirect:/login/logout";
    }

}
