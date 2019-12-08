package com.juyong.juc.consumerandproducer2;

/**
 * @Description: 消费者线程
 * @Author: juyong
 * @Date: 2019/12/8 19:34
 */
public class Consumer implements Runnable {
    private Store store ;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while(true){
            store.consumerMethod();
        }
    }
}
