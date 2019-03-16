package com.clive.service.impl;

import com.clive.bean.User;
import com.clive.mapper.UserMapper;
import com.clive.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserMapper userMapper;

    /**
     * 根据用户名返回用户全部信息
     * @param name
     * @return
     */
    @Override
    public User searchUserByName(String name) {
        User user = userMapper.userByName(name);
        return user;
    }

    /**
     *  模糊查询
     */
    @Override
    public List<User> searchUserByBlurName(String name) {
        return null;
    }

    /**
     *  根据id返回列表
     */
    @Override
    public List<User> searchUserById(String ID) {
        return null;
    }

    /**
     *  根据状态查询
     */
    @Override
    public List<User> searchUserByState(String state) {
        List<User> list = userMapper.userListByState(state);
        return list;
    }

    /**
     *  根据文章id返回用户
     */
    @Override
    public List<User> userListByArticleId(String id) {
        List<User> list = userMapper.userListByArticleId(id);
        return list;
    }
}
