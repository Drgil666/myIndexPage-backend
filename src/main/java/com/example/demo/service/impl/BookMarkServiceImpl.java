package com.example.demo.service.impl;
import com.example.demo.dao.BookMarkDao;
import com.example.demo.pojo.BookMark;
import com.example.demo.service.BookMarkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * @author Gilbert
 * @date 2020/12/17 20:38
 */
@Service
public class BookMarkServiceImpl implements BookMarkService {
    @Resource
    private BookMarkDao bookMarkDao;
    /**
     * 创建BookMark
     *
     * @param bookMark 要创建的BookMark
     * @return 带id的BookMark
     */
    @Override
    public BookMark createBookMark (BookMark bookMark) {
        return bookMarkDao.createBookMark (bookMark);
    }
    /**
     * 更新收藏夹
     *
     * @param bookMark 要更新的BookMark
     * @return 更新好的BookMark
     */
    @Override
    public BookMark updateBookMark (BookMark bookMark) {
        return bookMarkDao.updateBookMark (bookMark);
    }
    /**
     * 通过MongoId获取BookMark
     *
     * @param id BookMark的id
     * @return 对应的BookMark
     */
    @Override
    public BookMark getBookMark (String id) {
        return bookMarkDao.getBookMark (id);
    }
}
