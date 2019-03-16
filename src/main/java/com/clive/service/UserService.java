package com.clive.service;

import com.clive.bean.User;

/**
 * 用户信息服务 -增删改
 */
public interface UserService {

    //更新用户密码
    public boolean update_Login_password(String userName, String password, String newPassword);
    //更新用户邮箱
    public boolean update_Login_Email(String userName, String email, String newEmail);
    //更新用户手机
    public boolean update_Login_Phone(String userName, String userPhone, String newPhone);
    //更新用户头像
    public boolean update_Login_HeadPic(String userName, String userHeadPic, String newPic);
    //更新用户全部信息
    public boolean update_User(User user);

    public void updateVip(String uid);
}
