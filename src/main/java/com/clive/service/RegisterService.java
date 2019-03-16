package com.clive.service;

import com.clive.bean.User;

/**
 * 注册服务
 */
public interface RegisterService {
    // 注册账号
    public boolean registerUser(User user);
}
