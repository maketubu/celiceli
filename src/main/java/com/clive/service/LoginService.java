package com.clive.service;

/**
 * 登陆服务
 */
public interface LoginService {
    // 登陆账号判断
    public boolean CheckUser(String userName, String password);
    //登陆服务
    public boolean login();
}

