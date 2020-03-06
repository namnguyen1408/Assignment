package com.ass.controller;

import com.ass.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String index()
    {
        return "index";
    }
    @PostMapping("/logon")
    public ModelAndView login(Model model, @RequestParam("username") String username, @RequestParam("password") String password) {
        Users users = new Users(username, password);
        model.addAttribute("message", "Dang nhap thanh cong");
        ModelAndView modelAndView = new ModelAndView("/staffs/list", "users", users);
        return modelAndView;
    }
}
