package com.clive.service;

import com.clive.bean.User;

import java.util.List;

/**
 * 用户信息查询服务
 */
public interface UserInfoService {

    //根据名字查询用户对象
    public User searchUserByName(String name);
    //根据模糊名字查询用户列表
    public List<User> searchUserByBlurName(String name);
    //根据用户id返回用户列表
    public List<User> searchUserById(String ID);
    //根据用户状态返回用户列表
    public List<User> searchUserByState(String state);
    //根据帖子id返回发言用户列表
    public List<User> userListByArticleId(String id);
}

















