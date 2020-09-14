package com.lxk.mybatisdemo.entity;

import java.io.Serializable;

public class Course implements Serializable {
    private static final long serialVersionUID = -44876448211563407L;
    
    private String id;
    
    private String sname;
    
    private Double credit;
    
    private String teacher;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

}