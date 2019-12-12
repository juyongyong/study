package com.juyong.juc;

import java.util.concurrent.Semaphore;

/**
 * @Description: 使用信号量解决多线程循环打印问题
 * @Author: juyong
 * @Date: 2019/12/9 18:32
 */
public class LoopPrint2 {

    private Semaphore t1 = new Semaphore( 1);
    private Semaphore t2 = new Semaphore( 0);
    private Semaphore t3 = new Semaphore( 0);

    public static void main(String[] args) {
        LoopPrint2 loopPrint2 = new LoopPrint2() ;
        new Thread(()-> loopPrint2.print1()).start();
        new Thread(()-> loopPrint2.print2()).start();
        new Thread(()-> loopPrint2.print3()).start();
    }

    /*
     * @Author: juyong
     * @Description: 打印1的方法
     * @Date: 18:33 2019/12/9
     * @Param: [打印的值, 当前线程, 下一个打印线程]
     * @return: void
     **/
    public void print(int value,Semaphore current,Semaphore next){
        while(true){
            try {
                current.acquire();
                System.out.print(value);
                next.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void print1(){
        print(1,t1,t2);
    }

    public void print2(){
        print(2,t2,t3);
    }
    public void print3(){
        print(3,t3,t1);
    }




}
