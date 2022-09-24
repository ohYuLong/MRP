package com.jsoft.mrp.util;

// 后台向前台返回结果的统一的格式的工具类
public class MessageUtil {

    private int code;
    private String message;

    public MessageUtil(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
