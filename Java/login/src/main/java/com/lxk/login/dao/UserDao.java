package com.lxk.login.dao;

import com.lxk.login.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lxk
 */

@Mapper
public interface UserDao {
    /**
     * @return
     * user login
     */
//    @Select("select *from user where username=#{username} and password=#{password}")
    public User login(@Param("username") String username,@Param("password") String password);

    boolean register(User user);

//    @Select("SELECT COUNT(*) from user")
    int getId();
}
