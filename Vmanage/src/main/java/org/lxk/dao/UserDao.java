package org.lxk.dao;

import org.apache.ibatis.annotations.Param;
import org.lxk.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * @Author macos·lxk
 * @create 2020/7/18 6:08 下午
 */

@Repository
public interface UserDao {

    /**
     * userLogin用户登陆
     * @return
     * @param username
     * @param password
     */
    public UserEntity userLogin(@Param("username")String username,@Param("password")String password);
}
