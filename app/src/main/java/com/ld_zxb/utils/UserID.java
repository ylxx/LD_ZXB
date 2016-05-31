package com.ld_zxb.utils;

/**
 * Created by 派大星 on 2016/5/31 0031.
 */
public class UserID {
    /*持有私有静态实例，防止被引用*/
    private static UserID instance = null;
    /*私有构造方法，防止被实例化*/
    private UserID(){

    }
    private String userName=null;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public static void setInstance(UserID instance) {
        UserID.instance = instance;
    }
    public static UserID getInstance(){
        if(instance == null){
            instance = new UserID();
        }
        return instance;
    }
}
