package org.lxk.controller;

import org.lxk.common.result.CommResult;
import org.lxk.common.utils.MD5Util;
import org.lxk.dao.UserDao;
import org.lxk.entity.UserEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author macos·lxk
 * @create 2020/7/18 5:22 下午
 */

@Controller
@ResponseBody
@RequestMapping("user")
public class UserController {

    @Resource
    private UserDao userDao;

    @PostMapping(value = "userLogin",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommResult userLogin(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("password")String password){
        password = MD5Util.hash(password);
        UserEntity userEntity = userDao.userLogin(username,password);
        System.out.println(userEntity);
        if (userEntity != null){
            return CommResult.ok();
        }
        return CommResult.error("登陆失败");
    }
}
