package com.myblog.utils;


import org.apache.commons.codec.digest.DigestUtils;

public class MD5Utils {

    /**
     * 使用md5的算法进行加密
     */
    public static String md5Hex(String plainText) {
        String result = DigestUtils.md5Hex(plainText);
        return result;
    }

}
