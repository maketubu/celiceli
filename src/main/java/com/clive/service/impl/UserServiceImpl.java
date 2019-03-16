package com.clive.service.impl;

import com.clive.bean.User;
import com.clive.mapper.UserMapper;
import com.clive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public boolean update_Login_password(String userName, String password, String newPassword) {
        return false;
    }

    @Override
    public boolean update_Login_Email(String userName, String email, String newEmail) {
        return false;
    }

    @Override
    public boolean update_Login_Phone(String userName, String userPhone, String newPhone) {
        return false;
    }

    @Override
    public boolean update_Login_HeadPic(String userName, String userHeadPic, String newPic) {
        return false;
    }

    @Override
    public boolean update_User(User user) {
        return false;
    }

    @Override
    public void updateVip(String uid) {
        userMapper.updateVip(uid);
    }
}
