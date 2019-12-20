package com.juyong.simplefactory.order;

import com.juyong.simplefactory.pizza.GreekPizza;
import com.juyong.simplefactory.pizza.Pizza;

/**
 * @Description: 简单工厂
 * @Author: juyong
 * @Date: 2019/12/18 16:55
 */
public class SimpleFactory {

    public Pizza createPizza(String pizzaType){
        Pizza pizza = null ;
        System.out.println("使用简单工厂模式");
        if("greek".equals(pizzaType)){
            pizza = new GreekPizza("希腊") ;
        }else if("cheese".equals(pizzaType)){
            pizza = new GreekPizza("奶酪");

        }
        return pizza ;
    }
}
