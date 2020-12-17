package com.example.demo.service.impl;
import com.example.demo.DemoApplication;
import com.example.demo.pojo.BookMark;
import com.example.demo.service.BookMarkService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Gilbert
 * @date 2020/12/17 20:40
 */
@RunWith (SpringRunner.class)
@SpringBootTest (classes = DemoApplication.class)
public class BookMarkServiceImplTest {
    @Resource
    private BookMarkService bookMarkService;
    @Test
    public void createBookMark () {
        BookMark bookMark=new BookMark ();
        List<BookMark.BookMarkItem> bookMarkItemList=new ArrayList<> ();
        BookMark.BookMarkItem bookMarkItem=new BookMark.BookMarkItem ();
        bookMarkItem.setNick ("百度");
        bookMarkItem.setUrl ("www.baidu.com");
        bookMarkItemList.add (bookMarkItem);
        bookMark.setBookMarkItemList (bookMarkItemList);
        bookMarkService.createBookMark (bookMark);
        System.out.println (bookMark.getId ());
    }
    @Test
    public void updateBookMark () {
        BookMark bookMark=bookMarkService.getBookMark ("5fdb61aa412f912bacddc026");
        bookMark.getBookMarkItemList ().get (0).setUrl ("111");
        bookMarkService.updateBookMark (bookMark);

    }
    @Test
    public void getBookMark () {
        BookMark bookMark=bookMarkService.getBookMark ("5fdb61aa412f912bacddc026");
        System.out.println (bookMark);
    }
}