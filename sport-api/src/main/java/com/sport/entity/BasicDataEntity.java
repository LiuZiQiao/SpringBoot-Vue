package com.sport.entity;

import com.sport.common.entity.BasicEntity;

/**
 * @Author macos·lxk
 * @create 2020/7/8 12:44 下午
 */

public class BasicDataEntity extends BasicEntity {
    private static final long serialVersionUID = 1L;

    private Short type;

    private String name;

    private String basicCode;

    private String basicName;


    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBasicCode() {
        return basicCode;
    }

    public void setBasicCode(String basicCode) {
        this.basicCode = basicCode;
    }

    public String getBasicName() {
        return basicName;
    }

    public void setBasicName(String basicName) {
        this.basicName = basicName;
    }

}
