package com.example.demo.controller;
import com.example.demo.pojo.User;
import com.example.demo.pojo.vo.RequestVO;
import com.example.demo.pojo.vo.Response;
import com.example.demo.service.BcryptService;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
/**
 * @author Gilbert
 * @date 2020/12/18 10:52
 */
@Controller
@CrossOrigin (origins = "*")
@RequestMapping ("/api/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private BcryptService bcryptService;
    @ResponseBody
    @PostMapping ()
    public Response<User> user (@RequestBody RequestVO<User, Integer> request) {
        switch (request.getMethod ()) {
            case RequestVO.CREATE_METHOD: {
                if (! userService.isExist (request.getData ().getUsername ())) {
                    if (userService.createUser (request.getData ())) {
                        return Response.createSuc (request.getData ());
                    }
                    else {
                        return Response.createErr ("创建用户失败!");
                    }
                }
                else {
                    return Response.createErr ("用户已存在!");
                }
            }
            case RequestVO.UPDATE_METHOD: {
                if (userService.updateUser (request.getData ()) == 1) {
                    return Response.createSuc (request.getData ());
                }
                else {
                    return Response.createErr ("更新用户失败!");
                }
            }
            default:
                return Response.createErr ("method错误!");
        }
    }
    @ResponseBody
    @PostMapping ("/login")
    public Response<Integer> login (@RequestBody HashMap<String, String> map) {
        String username = map.get ("username");
        String password = map.get ("password");
        User user = userService.getUserByUsername (username);
        if (bcryptService.checkPassword (password,user.getPassword ())) {
            return Response.createSuc (user.getId ());
        }
        else {
            return Response.createErr ("用户名或密码错误!");
        }
    }
    @ResponseBody
    @GetMapping ()
    public Response<User> user (@RequestParam ("userId") Integer userId) {
        if (userId == null) {
            return Response.createErr ("userId为空!");
        }
        User user = userService.getUserById (userId);
        return Response.createSuc (user);
    }
}
