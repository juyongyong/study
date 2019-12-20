package com.juyong.simplefactory.order;

import com.juyong.simplefactory.pizza.CheesePizza;
import com.juyong.simplefactory.pizza.GreekPizza;
import com.juyong.simplefactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description: 订购披萨
 * @Author: juyong
 * @Date: 2019/12/18 16:00
 */
public class OrderPizza {
    private SimpleFactory simpleFactory ;
    Pizza pizza = null ;

    public OrderPizza(SimpleFactory simpleFactory) {
        setSimpleFactory(simpleFactory);
    }
    //定义一个简单工厂对象
    public void setSimpleFactory(SimpleFactory simpleFactory) {
        this.simpleFactory = simpleFactory;
        String pizzaType = "" ;//定义pizza类型
        do {
            pizzaType = getType() ;
            pizza = this.simpleFactory.createPizza(pizzaType) ;
            if(pizza != null){
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else{
                System.out.println("订购失败，没有你需要的披萨");
                break;
            }
        }while(true);

    }

    //写一个方法，可以获取客户希望订购披萨的种类
    public String getType(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input pizza种类：");
        try {
             return reader.readLine() ;
        } catch (IOException e) {
            e.printStackTrace();
            return "" ;
        }
    }
}
