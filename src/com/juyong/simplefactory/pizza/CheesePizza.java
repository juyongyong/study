package com.juyong.simplefactory.pizza;

import java.util.Calendar;

/**
 * @Description: 奶酪披萨
 * @Author: juyong
 * @Date: 2019/12/18 15:58
 */
public class CheesePizza extends Pizza{
    public CheesePizza(String name) {
        super(name);


    }

    @Override
    public void prepare() {
        System.out.println("给奶酪披萨准备原材料");
    }
}
