package com.example.demo.service;
import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
/**
 * @author Gilbert
 * @date 2020/12/17 20:22
 */
public interface UserService {
    /**
     * 创建用户
     *
     * @param user 用户
     * @return 创建好的用户
     */
    Boolean createUser (User user);
    /**
     * 更新用户
     *
     * @param user 用户
     * @return 更新好的用户
     */
    Long updateUser (User user);
    /**
     * 通过id获取用户
     *
     * @param userId 用户id
     * @return 用户信息
     */
    User getUserById (Integer userId);
    /**
     * 通过用户名
     *
     * @param username 用户名
     * @return 用户信息
     */
    User getUserByUsername (String username);
    /**
     * 判断用户名是否存在
     * @param username 用户名
     * @return 是否存在
     */
    Boolean isExist(@Param ("username") String username);
}
