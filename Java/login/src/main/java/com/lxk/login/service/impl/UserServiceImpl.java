package com.lxk.login.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.lxk.login.dao.UserDao;
import com.lxk.login.entity.User;
import com.lxk.login.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Administrator
 */

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User login(String username,String password) {
        User login = userDao.login(username,password);
        System.out.println(login);
        return login;
    }

    @Override
    public boolean register(User user) {
        if(userDao.register(user)){
            return true;
        }
        return false;
    }
}
