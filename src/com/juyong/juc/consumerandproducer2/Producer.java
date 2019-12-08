package com.juyong.juc.consumerandproducer2;

/**
 * @Description: 生产者线程
 * @Author: juyong
 * @Date: 2019/12/8 19:34
 */
public class Producer implements Runnable {
    private Store store ;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while(true) {
            store.producerMethod();
        }
    }
}
