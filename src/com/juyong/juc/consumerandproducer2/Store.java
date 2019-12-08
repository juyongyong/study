package com.juyong.juc.consumerandproducer2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 生产者消费者问题的仓库，使用队列模拟仓库
 * @Author: juyong
 * @Date: 2019/12/8 19:33
 */
public class Store {

    //使用队列模拟仓库
    private BlockingQueue<Goods> queue ;
    private static int count ;//记录一共生产了多少商品

    public Store(BlockingQueue<Goods> queue) {
        this.queue = queue;
    }

    //生产
    //synchronized程序执行完毕自动解锁，中途发生异常也会自动解锁
    //lock只能调用unlock解锁
    public synchronized void producerMethod(){
        Goods goods = new Goods(count,"商品"+count);
        try {
            //3代表数字，TimeUtil.SECONDS代表单位，这里表示3秒
            if(queue.size() == 100){
                wait();
            }else {
                boolean flag = queue.offer(goods, 3, TimeUnit.SECONDS);
                if (flag) {
                    count++;
                    System.out.println("生产成功：商品编号" + count);
                    Thread.sleep(100);
                    notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //消费
    public synchronized void consumerMethod(){
        try {
            if(queue.size() == 0){
                wait();
            }else {
                //出队
                Goods goods = queue.poll(3, TimeUnit.SECONDS);
                //如果不为空则代表消费成功
                if (goods != null) {
                    Thread.sleep(200);
                    System.out.println(Thread.currentThread().getName() + "消费成功->ID:" + goods.getId() + ",名字:" + goods.getName());
                    count--;
                    notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
