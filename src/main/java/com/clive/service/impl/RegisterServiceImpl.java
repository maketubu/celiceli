package com.clive.service.impl;

import com.clive.bean.User;
import com.clive.mapper.UserMapper;
import com.clive.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean registerUser(User user) {
        int result = userMapper.register(user);
        if (result != 0){
            return true;
        }else{
            return false;
        }
    }
}
