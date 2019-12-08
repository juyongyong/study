package com.juyong.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 测试lock的等待中断
 * @Author: juyong
 * @Date: 2019/12/8 22:28
 */
public class WaitInterrupt{

    private static Lock lock =new ReentrantLock() ;

    //如果线程被中断则抛出一个异常
    public void myLock(Thread thread) throws InterruptedException{
        try{
            //加一把可以中断的锁
            lock.lockInterruptibly();
            System.out.println(thread.getName()+"加锁");
            Thread.sleep(3000);
        }finally {
            lock.unlock();
            System.out.println(thread.getName()+"解锁");
        }
    }


    public static void main(String[] args) {
        WaitInterrupt waitInterrupt = new WaitInterrupt() ;
        Thread t1 =new MyThread(waitInterrupt,"A") ;
        Thread t2 =new MyThread(waitInterrupt,"B") ;
        t1.start();
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        t2.interrupt();
    }
}

class MyThread extends Thread{
    private WaitInterrupt waitInterrupt ;
    public MyThread(WaitInterrupt interrupt,String name) {
        super(name);
        this.waitInterrupt = interrupt ;
    }
    public void run(){
        //让当前线程休眠
        try {
            waitInterrupt.myLock(Thread.currentThread());
        }catch (Exception e){
            System.out.println(Thread.currentThread().getName()+"被中断了");
        }
    }
}
