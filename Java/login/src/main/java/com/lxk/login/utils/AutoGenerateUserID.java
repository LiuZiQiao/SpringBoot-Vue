package com.lxk.login.utils;

/**
 * @author Administrator
 */
public class AutoGenerateUserID {
    private static int id = 1;

    static {
        id++;
    }
    public static int getId(){
        return id;
    }
}
