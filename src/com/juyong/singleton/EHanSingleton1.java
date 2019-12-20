package com.juyong.singleton;

/**
 * @Description: 饿汉式单例
 * @Author: juyong
 * @Date: 2019/12/18 15:08
 */
public class EHanSingleton1 {
    public static volatile EHanSingleton1 instance = new EHanSingleton1() ;
    private EHanSingleton1(){}
    public static EHanSingleton1 getInstance(){
        return instance ;
    }

    public static void main(String[] args) {
        EHanSingleton1 singleton1 = null ;
        for(int i = 0 ; i < 100 ; i++){
            singleton1 = EHanSingleton1.getInstance();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(singleton1.hashCode());
        }
    }
}
