package com.lxk.login.dao;

import com.lxk.login.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author lxk
 */

//@Repository
@Mapper
public interface UserDao {
    /**
     * @return
     * user login
     */
    @Select("select *from user")
    public User login(User user);
}
