package com.example.demo.pojo.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * @author Happier233
 */
@Data
@AllArgsConstructor
public class Response<T> {
    private int code;
    private String msg;
    private T data;
    public static <T> Response<T> createSuc (T o) {
        return new Response<> (0,null,o);
    }
    public static <T> Response<T> createErr (String msg) {
        return new Response<> (- 1,msg,null);
    }
    public static <T> Response<T> createErr (int code,String msg) {
        return new Response<> (code,msg,null);
    }
}
