package com.clive.service.impl;

import com.clive.mapper.UserMapper;
import com.clive.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserMapper userMapper;
    /**
     * 检查用户是否存在与账号与密码是否匹配
     * @param userName
     * @param password
     * @return
     */
    @Override
    public boolean CheckUser(String userName, String password) {
        int result = userMapper.login(userName, password);
        if (result != 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean login() {
        return false;
    }
}
