package com.example.demo.pojo.vo;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import java.util.List;
/**
 * @author Gilbert
 * @author Happier233
 * @version 1.0
 * @date 2020/7/19 12:50
 */
@Data
public class RequestVO<T,K> {
    public static final String CREATE_METHOD = "create";
    public static final String UPDATE_METHOD = "update";
    public static final String DELETE_METHOD = "delete";
    private String method;
    private T data;
    private List<K> key;
}
