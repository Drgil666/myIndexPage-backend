package com.example.demo.service.impl;
import com.example.demo.DemoApplication;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Gilbert
 * @date 2020/12/17 20:25
 */
@RunWith (SpringRunner.class)
@SpringBootTest (classes = DemoApplication.class)
public class UserServiceImplTest {
    @Resource
    private UserService userService;
    @Test
    public void createUser () {
        User user=new User ();
        user.setUsername ("111");
        user.setPassword ("111");
        user.setBookmark ("111");
        user.setImg ("111");
        userService.createUser (user);
        System.out.println (user.getId ());
    }
    @Test
    public void updateUser () {
        User user=userService.getUserById (1);
        user.setPassword ("222");
        System.out.println (userService.updateUser (user));
    }
    @Test
    public void getUserById () {
        User user=userService.getUserById (1);
        System.out.println (user.getId ());
    }
    @Test
    public void getUserByUsername () {
        User user=userService.getUserByUsername ("111");
        System.out.println (user.getId ());
    }
    @Test
    public void isExist(){
        System.out.println (userService.isExist ("111"));
    }
}