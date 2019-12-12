package com.juyong.juc.consumerandproducer1;

/**
 * @Description: 生产者线程
 * @Author: juyong
 * @Date: 2019/12/9 18:09
 */
public class Producer implements Runnable {

    private Store store ;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while(true){
            store.producerMethod();
        }
    }
}
