package com.jsoft.mrp.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {

    /*
    *   获取用来加密的盐
    * */
    public static String getSalt() {
//        从我定义的一组数据中拿出几个字母或者数字或者符号当做盐
        String words = "abcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+~";
        StringBuilder strb = new StringBuilder();
//        从我定义的数据中取出8个字符，当做盐
        for (int i = 0; i < 8; i++) {
//            随机取
//            生成一个0-字符串的长度的随机数 [0,长度)
            strb.append(words.charAt((int) Math.floor(Math.random() * words.length())));
        }
        return strb.toString();
    }
    /*
     *   这个方法的参数是原始密码，在controller通过request.getParameter("")接到的写在密码框中的密码
     *   返回值是经过加密处理过后的密码
     *   加盐 salt
     *   MD5 + 盐 加密
     *   MD5算法
     *
     * */
    public static String stringToMD5(String str) {
        return DigestUtils.md5Hex(str.getBytes());
    }


//    public static void main(String[] args) {
//        e10adc3949ba59abbe56e057f20f883e
//        System.out.println(stringToMD5("123456"));
//        System.out.println(getSalt());
//        System.out.println(stringToMD5("123456" + getSalt()));
//    }

}
