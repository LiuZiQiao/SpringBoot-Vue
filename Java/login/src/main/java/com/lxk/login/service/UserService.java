package com.lxk.login.service;

import com.lxk.login.entity.User;

/**
 * @author Administrator
 */
public interface UserService {

    public User login(String username,String password);

    public boolean register(User user);
}
