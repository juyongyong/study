package com.juyong.juc.consumerandproducer3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description: 测试使用lock代替synchronized
 * @Author: juyong
 * @Date: 2019/12/8 22:01
 */
public class Test {
    public static void main(String[] args) {
        //创建一个容量为20的队列
        BlockingQueue<Goods> queue = new LinkedBlockingQueue<>(100);
        //创建一个仓库
        Store store = new Store(queue) ;
        //创建生产者消费者线程
        Consumer c1 = new Consumer(store) ;
        Consumer c2 = new Consumer(store) ;
        Producer p1 = new Producer(store);
        Producer p2 = new Producer(store);

        //创建一个线程池管理线程
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(c1);
        executorService.execute(c2);
        executorService.execute(p1);
        executorService.execute(p2);
        //执行五秒然后关闭线程池
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
