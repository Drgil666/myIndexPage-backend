package com.example.demo.pojo;
import lombok.Data;
/**
 * @author Gilbert
 * @date 2020/12/17 19:36
 */
@Data
public class User
{
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 用户头像
     */
    private String img;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 收藏夹的MongoId
     */
    private String bookmark;
}
