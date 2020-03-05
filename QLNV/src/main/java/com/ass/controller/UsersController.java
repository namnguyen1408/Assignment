package com.ass.controller;

import com.ass.model.Depart;
import com.ass.model.Users;
import com.ass.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {
@Autowired
    private UserService userService;
    @GetMapping("/users")
      public ModelAndView listUsers(){
        Iterable<Users> users = userService.findAll();
        ModelAndView modelAndView = new ModelAndView("/users/list");
        modelAndView.addObject("users",new Users());
        return modelAndView;
    }
    @GetMapping("/create-users")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView= new ModelAndView("/users/create");
        modelAndView.addObject("users",new Users());
        return modelAndView;
    }
    @PostMapping("/create-users")
    public  ModelAndView saveUsers(@ModelAttribute("users") Users users){
        userService.save(users);
        ModelAndView modelAndView = new ModelAndView("/users/create");
        modelAndView.addObject("users",new Users());
        modelAndView.addObject("message","Successfully!!!");
        return modelAndView;
    }


}
