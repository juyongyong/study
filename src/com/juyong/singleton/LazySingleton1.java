package com.juyong.singleton;

/**
 * @Description: 懒汉式2加Synchronized
 * @Author: juyong
 * @Date: 2019/12/18 15:22
 */
public class LazySingleton1 {
    public static LazySingleton1 instance ;
    private LazySingleton1(){}
    public synchronized static LazySingleton1 getInstance(){
        if(instance == null){
            instance = new LazySingleton1() ;
        }
        return instance ;
    }

    public static void main(String[] args) {
        for(int i = 0 ; i < 10 ; i ++){
            new Thread(()->{
                LazySingleton1 instance ;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                instance = LazySingleton1.getInstance();
                System.out.println(instance.hashCode());
            }).start();
        }
    }
}
