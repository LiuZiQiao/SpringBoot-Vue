package com.lxk.login.utils;

import com.lxk.login.dao.UserDao;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
public class AutoGenerateUserID {

    public AutoGenerateUserID() {
    }

    private static int id = 100;

    public int getId(){
        return ++id;
    }
//    @Resource
//    private UserDao userDao;
//    public int getId(){
//        int id = userDao.getId();
//        System.out.println(id);
//        return ++id;
//    }
}
