package com.juyong.singleton;

/**
 * @Description: 静态内部类单例模式
 * @Author: juyong
 * @Date: 2019/12/18 15:34
 */
public class StaticInnerClassSingleton {
    public static volatile StaticInnerClassSingleton instance ;
    private StaticInnerClassSingleton(){}
    public static class InnerClass{
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton() ;

    }

    public static StaticInnerClassSingleton getInstance(){
        return InnerClass.INSTANCE ;
    }


    public static void main(String[] args) {
        for(int i = 0 ; i < 10 ; i++){
            new Thread(()->{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(StaticInnerClassSingleton.getInstance().hashCode());
            }).start();
        }
    }
}
