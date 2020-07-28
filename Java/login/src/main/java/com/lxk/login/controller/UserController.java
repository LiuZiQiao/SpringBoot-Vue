package com.lxk.login.controller;

import com.lxk.login.entity.User;
import com.lxk.login.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    UserService userService;


    @ResponseBody
    @PostMapping(value = "/login")
    public String login(@Param("username")String username, @Param("password")String password){
        User user = userService.login(username,password);
        String msg = "";
        if (user != null){
            msg = "success";
        }
        return "failed";
    }

    @ResponseBody
    @PostMapping(value = "/test")
    public String test(@Param("username")String username, @Param("password")String password){
        User user = userService.login(username,password);
        String msg = "";
        if (user != null){
            msg = "success";
        }
        return "failed";
    }

    @ResponseBody
    @RequestMapping("/")
    public String hello(){
        return  "hello";
    }
}
