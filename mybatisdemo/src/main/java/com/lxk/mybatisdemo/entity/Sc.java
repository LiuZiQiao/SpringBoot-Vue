package com.lxk.mybatisdemo.entity;

import java.io.Serializable;


public class Sc implements Serializable {
    private static final long serialVersionUID = -84354584306036800L;
    
    private String sid;
    
    private String cid;


    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

}