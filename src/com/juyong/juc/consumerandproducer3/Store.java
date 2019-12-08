package com.juyong.juc.consumerandproducer3;

import javax.swing.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 仓库
 * @Author: juyong
 * @Date: 2019/12/8 21:48
 */
public class Store {
    //用于存放货物的队列
    private BlockingQueue<Goods> queue ;
    //获取到Lock对象
    private Lock lock = new ReentrantLock() ;
    //获取Condition对象
    private Condition condition = lock.newCondition() ;
    //用于统计一共生产了多少个商品
    private static int count ;

    public Store(BlockingQueue<Goods> queue) {
        this.queue = queue;
    }

    //生产
    public void producerMethod(){
        lock.lock();
        try{
            if(queue.size() == 100){
                condition.await();
            }else{
                Goods goods = new Goods(++count,"第"+count+"件商品") ;
                //返回值表示入队成功或失败
                boolean flag = queue.offer(goods, 3, TimeUnit.SECONDS);
                if(flag){
                    System.out.println(Thread.currentThread().getName()+"生产者生产第"+count+"件商品成功,库存"+queue.size());
                    condition.signalAll();
                }
            }
        }catch (InterruptedException e){}finally {
            lock.unlock();
        }
    }

    //消费
    public void consumerMethod(){
        lock.lock();
        try{
            if(queue.size() == 0){
                condition.await();
            }else{
                Goods goods = queue.poll(3, TimeUnit.SECONDS);
                if(goods !=  null){
                    System.out.println(Thread.currentThread().getName()+"消费者消费商品ID:"+goods.getId()+",名字:"+goods.getName());
                    condition.signalAll();
                }
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
