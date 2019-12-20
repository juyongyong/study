package com.juyong.singleton;

/**
 * @Description: 双重检查单例
 * @Author: juyong
 * @Date: 2019/12/11 17:00
 */
public class DoubleCheckSingleton {

    private static DoubleCheckSingleton instance = null ;

    private DoubleCheckSingleton() {
    }

    public static DoubleCheckSingleton getInstance(){
        if(instance == null){
            synchronized (DoubleCheckSingleton.class){
                if(instance == null){
                    instance = new DoubleCheckSingleton() ;
                }
            }
        }
        return instance ;
    }
}
