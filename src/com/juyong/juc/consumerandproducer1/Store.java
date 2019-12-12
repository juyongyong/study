package com.juyong.juc.consumerandproducer1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 仓库
 * @Author: juyong
 * @Date: 2019/12/9 17:58
 */
public class Store {
    //使用队列模拟仓库
    private BlockingQueue<Car> queue ;
    //使用信号量来实现生产者消费者线程
    private Semaphore consumer = new Semaphore(0);
    private Semaphore producer = new Semaphore(10) ;

    //用于统计一共生产了多少量车
    private static int count = 0;

    public Store(BlockingQueue<Car> queue) {
        this.queue = queue;
    }

    //消费
    public void consumerMethod(){
        try {
            //先获取消费者的许可集，只有获取到了许可集菜呢个继续往下执行
            consumer.acquire();
            Car car = queue.poll(3, TimeUnit.SECONDS);
            String name = Thread.currentThread().getName();
            if(car != null){
                System.out.println(name+"买车成功，车牌ID："+car.getId()+",车标:"+car.getName()+",库存:"+queue.size());
                producer.release();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //生产
    public void producerMethod(){
        try {
            producer.acquire();
            Car car = new Car(++count,"奔驰"+count);
            boolean flag = queue.offer(car, 3, TimeUnit.SECONDS);
            if(flag){
                String name = Thread.currentThread().getName() ;
                System.out.println(name+"造车成功,车牌ID:"+car.getId()+",车标:"+car.getName()+",库存:"+queue.size());
                consumer.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
