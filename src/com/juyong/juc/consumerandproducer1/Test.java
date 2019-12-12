package com.juyong.juc.consumerandproducer1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description: 使用信号量测试生产者消费者线程
 * @Author: juyong
 * @Date: 2019/12/9 18:10
 */
public class Test {

    //创建一个队列
    private static BlockingQueue<Car> queue = new LinkedBlockingQueue<>(10) ;
    //创建一个仓库
    private static Store store = new Store(queue) ;
    public static void main(String[] args) {
        //消费者
        Consumer c1 = new Consumer(store) ;
        Consumer c2 = new Consumer(store) ;
        Thread t1 = new Thread(c1,"消费者A") ;
        Thread t2 = new Thread(c1,"消费者B") ;

        //生产者
        Producer p1 = new Producer(store) ;
        Producer p2 = new Producer(store) ;
        Thread t3 = new Thread(p1,"生产者A") ;
        Thread t4 = new Thread(p2,"生产者B") ;

        //创建线程池启动线程
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(t1);
        executorService.execute(t2);
        executorService.execute(t3);
        executorService.execute(t4);
    }
}
