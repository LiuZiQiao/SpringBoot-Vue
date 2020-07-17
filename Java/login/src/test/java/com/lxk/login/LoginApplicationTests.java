package com.lxk.login;

import com.lxk.login.dao.UserDao;
import com.lxk.login.entity.User;
import com.lxk.login.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@SpringBootTest
class LoginApplicationTests {

    @Resource
    private UserService userService;
    User user = null;
    @Test
    void contextLoads() {
        user = userService.login(user);
        System.out.println(user);
    }

}
