package com.lxk.login.service;

import com.lxk.login.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
public interface UserService {

    public User login(String username,String password);
}
