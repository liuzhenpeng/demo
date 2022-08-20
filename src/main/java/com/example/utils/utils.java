package com.example.utils;

import java.util.Date;

public class utils {
    /**
     * 获取精确到秒的时间戳
     * @return
     */
    public static int getSecondTimestamp(){
        String timestamp = String.valueOf(new Date().getTime()/1000);
        return Integer.valueOf(timestamp);
    }


}
