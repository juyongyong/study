package com.juyong.juc.consumerandproducer2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description: TODO
 * @Author: juyong
 * @Date: 2019/12/8 20:20
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Goods> queue = new LinkedBlockingQueue<>(100);
        Store store = new Store(queue) ;
        //创建一个带缓冲区的线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //消费者
        Consumer c1 = new Consumer(store) ;
        Consumer c2 = new Consumer(store) ;
        //生产者
        Producer p1 = new Producer(store) ;
        Producer p2 = new Producer(store) ;
        executorService.execute(c1);
        executorService.execute(c2);
        executorService.execute(p1);
        executorService.execute(p2);
        Thread.sleep(3000);
        //执行三秒关闭线程池
        executorService.shutdown();



    }
}
