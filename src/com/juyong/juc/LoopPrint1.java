package com.juyong.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 多线程打印问题
 * @Author: juyong
 * @Date: 2019/12/9 18:18
 */
public class LoopPrint1 extends Thread{

    private Lock lock =new ReentrantLock() ;
    private Condition condition1 = lock.newCondition() ;
    private Condition condition2 = lock.newCondition() ;
    private Condition condition3 = lock.newCondition() ;
    private static int num  = 1 ;

    //打印1
    public void print1(){
        try{
            lock.lock();
            if(num != 1){
                condition1.await();
            }
            System.out.print(num);
            num = 2 ;
            condition2.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    //打印2
    public void print2(){
        try{
            lock.lock();
            if(num != 2){
                condition2.await();
            }
            System.out.print(num);
            num = 3 ;
            condition3.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    //打印3
    public void print3(){
        try{
            lock.lock();
            if(num != 3){
                condition3.await();
            }
            System.out.print (num+" ");
            num = 1 ;
            condition1.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LoopPrint1 loopPrint1 = new LoopPrint1() ;
        //创建三个线程
        new Thread(()->{
            while (true){
                loopPrint1.print1();
            }
        }).start();

        new Thread(()->{
            while (true){
                loopPrint1.print2();
            }
        }).start();

        new Thread(()->{
            while (true){
                loopPrint1.print3();
            }
        }).start();
    }
}

