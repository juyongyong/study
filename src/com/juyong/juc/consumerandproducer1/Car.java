package com.juyong.juc.consumerandproducer1;

/**
 * @Description: 汽车类
 * @Author: juyong
 * @Date: 2019/12/9 17:58
 */
public class Car {
    private int id ;

    private String name ;

    public Car() {
    }

    public Car(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
