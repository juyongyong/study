package com.juyong.singleton;

/**
 * @Description: 双重检查式懒汉单例
 * @Author: juyong
 * @Date: 2019/12/18 15:30
 */
public class LazySingleton3 {
    public static volatile LazySingleton3 instance ;
    private LazySingleton3(){}
    public static LazySingleton3 getInstance(){
        if(instance == null){
            synchronized (LazySingleton3.class){
                if(instance == null){
                    instance = new LazySingleton3() ;
                }
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
                System.out.println(LazySingleton3.getInstance().hashCode());
            }).start();
        }
    }

}
