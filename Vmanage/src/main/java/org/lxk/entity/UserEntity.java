package org.lxk.entity;

import org.lxk.common.entity.BasicEntity;

/**
 * @Author macos·lxk
 * @create 2020/7/18 5:56 下午
 */

public class UserEntity extends BasicEntity {
    private static final long serializableUID = 1L;

    private long id;
    private String username;
    private String password;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
