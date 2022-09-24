package com.jsoft.mrp.util;

public class ResultUtil {

    private Object key;
    private Object value;

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public ResultUtil() {
    }

    public ResultUtil(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
}
