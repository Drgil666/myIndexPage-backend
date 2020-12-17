package com.example.demo.pojo;
import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
/**
 * @author Gilbert
 * @date 2020/12/17 19:45
 */
@Data
@Document (collection = "bookmark")
@Alias ("bookmark")
public class BookMark {
    @Id
    private String id;
    private List<BookMarkItem> bookMarkItemList;
    @Data
    public static class BookMarkItem {
        private String nick;
        private String url;
    }
}
