package com.lxk.login.controller;

import com.lxk.login.entity.User;
import com.lxk.login.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    UserService userService;


    @ResponseBody
    @RequestMapping("login")
    public String login(){
        User user = null;
        User user1 = userService.login(user);
        System.out.println("---------------");
        return user1.toString();
    }
}
