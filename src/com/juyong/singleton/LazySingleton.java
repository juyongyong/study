package com.juyong.singleton;

import java.util.Random;

/**
 * @Description: //懒汉式单例模式（不安全）
 * @Author: juyong
 * @Date: 2019/12/18 15:14
 */
//单例模式保证了系统内存中该类只存在一个对象，节省了系统资源，对于一些需要频繁创建和销毁的对象，使用单例模式可以提高性能
//当想实例化一个单例类的时候，必须要记住使用相应的获取对象的方法，而不是使用new来获取
//单例模式的使用场景：需要频繁的进行创建和销毁的对象、创建对象时耗时过多或耗费资源过多(即重量级对象)，
// 但又经常使用到的对象、工具类对象、频繁访问数据库文件的对象(比如数据源，session工厂等)
public class LazySingleton {
    private static LazySingleton instance ;
    private LazySingleton(){}
    public static LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton() ;
        }
        return instance ;
    }

    public static void main(String[] args) {
       for(int i = 0 ; i <  100 ; i++){
           new Thread(()->{
               LazySingleton instance = null ;

               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               instance = LazySingleton.getInstance() ;
               System.out.println(instance.hashCode());
           }).start();
       }
    }
}
