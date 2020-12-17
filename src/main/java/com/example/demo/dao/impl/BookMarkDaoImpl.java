package com.example.demo.dao.impl;
import com.example.demo.dao.BookMarkDao;
import com.example.demo.pojo.BookMark;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
/**
 * @author Gilbert
 * @date 2020/12/17 19:55
 */
@Component ("BookMarkDaoImpl")
public class BookMarkDaoImpl implements BookMarkDao {
    @Resource
    private MongoTemplate mongoTemplate;
    /**
     * 创建收藏夹
     *
     * @param bookMark 收藏夹
     * @return 带id的收藏夹
     */
    @Override
    public BookMark createBookMark (BookMark bookMark) {
        return mongoTemplate.insert (bookMark);
    }
    /**
     * 更新收藏夹
     *
     * @param bookMark 要更新的BookMark
     * @return 更新好的BookMark
     */
    @Override
    public BookMark updateBookMark (BookMark bookMark) {
        return mongoTemplate.save (bookMark);
    }
    /**
     * 通过MongoId获取BookMark
     *
     * @param id BookMark的id
     * @return 对应的BookMark
     */
    @Override
    public BookMark getBookMark (String id) {
        Query query = new Query ();
        query.addCriteria (Criteria.where ("_id").is (id));
        return mongoTemplate.findOne (query,BookMark.class);
    }
}
