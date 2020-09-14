package com.lxk.demo.user.service;

import com.lxk.demo.user.po.User;

/**
 * @Description TODO
 * @Author liuxk@e6yun.com
 * @Created Date: 2020/8/27 17:04
 * @ClassName UserService
 * @Remark
 */

public interface UserService {
    void insert(User user);
    public String findUserName(String tel);
}
