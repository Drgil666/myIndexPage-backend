package com.example.demo.service.impl;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * @author Gilbert
 * @date 2020/12/17 20:23
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    /**
     * 创建用户
     *
     * @param user 用户
     * @return 创建好的用户
     */
    @Override
    public Boolean createUser (User user) {
        return userMapper.createUser (user);
    }
    /**
     * 更新用户
     *
     * @param user 用户
     * @return 更新好的用户
     */
    @Override
    public Long updateUser (User user) {
        return userMapper.updateUser (user);
    }
    /**
     * 通过id获取用户
     *
     * @param userId 用户id
     * @return 用户信息
     */
    @Override
    public User getUserById (Integer userId) {
        return userMapper.getUserById (userId);
    }
    /**
     * 通过用户名
     *
     * @param username 用户名
     * @return 用户信息
     */
    @Override
    public User getUserByUsername (String username) {
        return userMapper.getUserByUsername (username);
    }
    /**
     * 判断用户名是否存在
     *
     * @param username 用户名
     * @return 是否存在
     */
    @Override
    public Boolean isExist (String username) {
        return userMapper.isExist (username)>0;
    }
}
