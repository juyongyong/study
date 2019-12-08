package com.juyong.juc.consumerandproducer3;

/**
 * @Description: 消费者线程
 * @Author: juyong
 * @Date: 2019/12/8 22:00
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
