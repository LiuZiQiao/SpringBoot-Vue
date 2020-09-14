package com.lxk.mybatisdemo.entity;

import javax.annotation.Generated;
import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = -66837953443662715L;

    private Integer id;
    
    private String sname;
    
    private Integer age;
    
    private String sex;
    
    private String classNum;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }
}