package com.juyong.singleton;

/**
 * @Description: TODO
 * @Author: juyong
 * @Date: 2019/12/18 15:12
 */
public class EHanSingleton2 {
    public static EHanSingleton2 instance ;
    static {
        instance = new EHanSingleton2() ;
    }

    public static EHanSingleton2 getInstance(){
        return instance ;
    }
}
