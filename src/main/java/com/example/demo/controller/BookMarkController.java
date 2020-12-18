package com.example.demo.controller;
import com.example.demo.pojo.BookMark;
import com.example.demo.pojo.User;
import com.example.demo.pojo.vo.RequestVO;
import com.example.demo.pojo.vo.Response;
import com.example.demo.service.BookMarkService;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * @author Gilbert
 * @date 2020/12/18 12:53
 */
@Controller
@RequestMapping ("/api/bookmark")
@CrossOrigin (origins = "*")
public class BookMarkController {
    @Resource
    private BookMarkService bookMarkService;
    @Resource
    private UserService userService;
    @ResponseBody
    @PostMapping ()
    public Response<BookMark> bookmark (@RequestBody RequestVO<BookMark, Integer> request) {
        switch (request.getMethod ()) {
            case RequestVO.CREATE_METHOD: {
                bookMarkService.createBookMark (request.getData ());
                if (request.getData ().getId () != null) {
                    return Response.createSuc (request.getData ());
                }
                else {
                    return Response.createErr ("创建BookMark失败!");
                }
            }
            case RequestVO.UPDATE_METHOD: {
                if (bookMarkService.updateBookMark (request.getData ()) != null) {
                    return Response.createSuc (request.getData ());
                }
                else {
                    return Response.createErr ("更新BookMark失败!");
                }
            }
            default:
                return Response.createErr ("method错误!");
        }
    }
    @ResponseBody
    @GetMapping ()
    public Response<BookMark> bookmark (@RequestParam ("userId") Integer userId) {
        User user = userService.getUserById (userId);
        String mongoId = user.getBookmark ();
        BookMark bookMark = bookMarkService.getBookMark (mongoId);
        return Response.createSuc (bookMark);
    }
}
