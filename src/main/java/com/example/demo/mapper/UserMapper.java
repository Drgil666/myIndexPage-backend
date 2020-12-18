package com.example.demo.mapper;
import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
/**
 * @author Gilbert
 * @date 2020/12/17 19:53
 */
@Mapper
public interface UserMapper {
    /**
     * 创建用户
     *
     * @param user 用户
     * @return 创建好的用户
     */
    @Options (useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert ("insert into user (username,password,img,bookmark,nick) values (#{user.username},#{user.password},#{user.img},#{user.bookmark},#{user.nick})")
    Boolean createUser (@Param ("user") User user);
    /**
     * 更新用户
     *
     * @param user 用户
     * @return 更新好的用户
     */
    @Update ("update user set username=#{user.username},password=#{user.password},bookmark=#{user.bookmark},img=#{user.img},nick=#{user.nick} where id=#{user.id}")
    Long updateUser (@Param ("user") User user);
    /**
     * 通过id获取用户
     *
     * @param userId 用户id
     * @return 用户信息
     */
    @Select ("select * from user where id=#{userId}")
    User getUserById (@Param ("userId") Integer userId);
    /**
     * 通过用户名
     *
     * @param username 用户名
     * @return 用户信息
     */
    @Select ("select * from user where username=#{username}")
    User getUserByUsername (@Param ("username") String username);
    /**
     * 判断用户名是否存在
     * @param username 用户名
     * @return 用户名个数
     */
    @Select ("select count(*) from user where username=#{username} LIMIT 1")
    Long isExist(@Param ("username") String username);
}
