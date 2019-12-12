package com.juyong.volatile1;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 此时volatile是否能保证原子性，线程安全
 * @Author: juyong
 * @Date: 2019/12/11 18:23
 */
public class TestVolatile {
//    static volatile  int num = 0 ;
    static AtomicInteger num = new AtomicInteger(0) ;
    public static void main(String[] args) {
        for(int i = 0 ; i < 100 ; i++){
            new Thread(()->{
                for(int j = 0 ; j < 300 ; j++){
//                    num++ ;//不是一个原子性操作
                    //num = num + 1 ;
                    num.incrementAndGet();

                }
            }).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(num);
    }
}
