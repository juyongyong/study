package com.juyong.singleton;

/**
 * @Description: 懒汉式不安全写法
 * @Author: juyong
 * @Date: 2019/12/18 15:26
 */
public class LazySingleton2 {
    public static LazySingleton2 instance ;
    private LazySingleton2(){}
    public static LazySingleton2 getInstance(){
        if(instance == null){
            synchronized (LazySingleton2.class){
                instance = new LazySingleton2() ;
            }
        }
        return instance ;
    }

    public static void main(String[] args) {
        for(int i = 0 ; i < 10 ; i++){
            new Thread(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(LazySingleton2.getInstance().hashCode());
            }).start();
        }
    }
}
