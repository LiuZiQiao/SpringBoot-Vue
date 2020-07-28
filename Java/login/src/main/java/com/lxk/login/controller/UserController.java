package com.lxk.login.controller;

import com.lxk.login.common.result.CommResult;
import com.lxk.login.entity.User;
import com.lxk.login.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

import com.lxk.login.utils.AutoGenerateUserID;

/**
 * @author Administrator
 */
@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommResult login(@Param("username") String username, @Param("password") String password) {
        User user = userService.login(username, password);
        System.out.println(user);
        if (user != null) {
            return CommResult.ok();
        }
        return CommResult.error("登录失败");
    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommResult register(@Param("username") String username, @Param("realname") String realname,
                               @Param("password") String password, @Param("email") String email, @Param("sex") String sex) {
        User user = new User();
        AutoGenerateUserID auto = new AutoGenerateUserID();
        int id = auto.getId();
        user.setUserId(id);
        user.setUserName(username);
        user.setRealName(realname);
        user.setPassword(password);
        user.setEmail(email);
        user.setSex(sex);
        user.setLoginTime(new Date());
        System.out.println(user);

        boolean flag = userService.register(user);
        if (flag) {
            return CommResult.ok();
        }
        return CommResult.error("注册失败");
    }


    @ResponseBody
    @RequestMapping("/")
    public String hello() {
        return "hello";
    }
}
