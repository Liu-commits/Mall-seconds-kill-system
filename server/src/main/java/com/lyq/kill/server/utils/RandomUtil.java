package com.lyq.kill.server.utils;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @ClassName RandowUtil
 * @Description 订单编号
 * @Author LYQ
 * @Date 2020/3/29 16:11
 * @Version 1.0
 **/


public class RandomUtil {
    
    private static final SimpleDateFormat dateFormatOne = new SimpleDateFormat("yyyyMMddHHmmssSS");
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();
    /*
     * @Author LYQ
     * @Description 生成订单编号
     * @Date 16:13 2020/3/29
     * @Param []
     * @return java.lang.String
     **/
    public static String generateOrderCode(){
        //时间戳加N位随机数流水号
        return  dateFormatOne.format(DateTime.now().toDate())+generateNum(5);
        
    }
    
    
    
    public static String generateNum(final int num){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num ; i++) {
            int a = random.nextInt(9);
            sb.append(a);
        }
        return sb.toString();
    }

    /*public static void main(String[] args) {
        for (int i = 0; i <1000000 ; i++) {
            System.out.println(generateOrderCode());
        }
    }*/
}
