package com.juyong.singleton;

//枚举单例
public enum EnumSingleton {
    INSTANCE;

    public static void main(String[] args) {
        for(int i = 0 ; i < 10 ;i ++){
            new Thread(()->{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(EnumSingleton.INSTANCE.hashCode());
            }).start();
        }
    }
}
