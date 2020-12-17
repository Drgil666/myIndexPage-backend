package com.example.demo.service;
import com.example.demo.pojo.BookMark;
/**
 * @author Gilbert
 * @date 2020/12/17 20:38
 */
public interface BookMarkService {
    /**
     * 创建BookMark
     *
     * @param bookMark 要创建的BookMark
     * @return 带id的BookMark
     */
    BookMark createBookMark (BookMark bookMark);
    /**
     * 更新收藏夹
     *
     * @param bookMark 要更新的BookMark
     * @return 更新好的BookMark
     */
    BookMark updateBookMark (BookMark bookMark);
    /**
     * 通过MongoId获取BookMark
     *
     * @param id BookMark的id
     * @return 对应的BookMark
     */
    BookMark getBookMark (String id);
}
