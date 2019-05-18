package com.myblog.utils;

import java.util.UUID;

public class BaseUtils {


    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }


}
