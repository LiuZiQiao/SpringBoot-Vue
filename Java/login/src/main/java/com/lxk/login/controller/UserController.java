package com.lxk.login.controller;

import com.lxk.login.entity.User;
import com.lxk.login.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    UserService userService;


    @ResponseBody
    @RequestMapping("/login")
    public String login(@Param("username")String username, @Param("password")String password){
        User user = userService.login(username,password);
        String msg = "";
        if (user != null){
            msg = "success";
        }
        return "failed";
    }
}
