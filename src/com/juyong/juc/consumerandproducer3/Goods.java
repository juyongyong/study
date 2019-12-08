package com.juyong.juc.consumerandproducer3;

/**
 * @Description: 生产者的生产的货物
 * @Author: juyong
 * @Date: 2019/12/8 21:48
 */
public class Goods {

    private int id ;

    private String name ;

    public Goods() {
    }

    public Goods(int id, String name) {
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
