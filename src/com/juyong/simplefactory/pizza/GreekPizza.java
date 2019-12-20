package com.juyong.simplefactory.pizza;

/**
 * @Description: 希腊披萨
 * @Author: juyong
 * @Date: 2019/12/18 15:59
 */
public class GreekPizza extends Pizza {
    public GreekPizza(String name) {
        super(name);
    }

    @Override
    public void prepare() {
        System.out.println("给希腊披萨准备原材料");
    }
}
