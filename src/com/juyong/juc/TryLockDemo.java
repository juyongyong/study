package com.juyong.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 测试尝试枷锁
 * @Author: juyong
 * @Date: 2019/12/8 22:21
 */
public class TryLockDemo extends Thread{
    private static Lock lock = new ReentrantLock() ;
    private boolean flag = false ;

    public TryLockDemo(String name){
        super(name);
    }

    @Override
    public void run(){
        String name = Thread.currentThread().getName();
        try {
            flag = lock.tryLock(5, TimeUnit.MICROSECONDS);
            //获取线程名字
            if(flag){
                System.out.println(name+"加锁成功");
            }else{
                System.out.println(name+"加锁失败");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if(flag){
                lock.unlock();
                System.out.println(name+"解锁成功");
            }
        }
    }

    public static void main(String[] args) {
        TryLockDemo t1 = new TryLockDemo("线程A") ;
        TryLockDemo t2 = new TryLockDemo("线程B") ;

        t1.start();
        t2.start();



    }
}

