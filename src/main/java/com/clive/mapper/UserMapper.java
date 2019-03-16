package com.clive.mapper;


import java.util.List;

import com.clive.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    // 登陆检测
    public int login(String userName, String password);
    //注册
    public int register(User user);
    // 修改密码
    public int updateLoginPassword(String userName, String password, String newPassword);
    //修改邮箱
    public int updateLoginEmail(String userName, String email, String newEmail);
    //修改头像
    public int updateLoginHeadPic(String userName, String pic, String newPic);
    //修改用户全部信息
    public int updateUserInfoAll(User user);
    //根据用户姓名查询用户的所有信息
    public User userByName(String userName);
    //根据文章id返回发言用户列表
    public List<User> userListByArticleId(String id);
    //根据用户状态返回用户列表
    public List<User> userListByState(String state);

    public int selectUserVip(String userName);

    public void updateVip(String userName);
}
