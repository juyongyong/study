package com.juyong.simplefactory.order;

/**
 * @Description: 披萨店
 * @Author: juyong
 * @Date: 2019/12/18 16:09
 */
public class PizzaStore {
    public static void main(String[] args) {
        new OrderPizza(new SimpleFactory()) ;
    }

    public static void equal(String s){
        String str= "abc" ;
        int aaa ;
        if(s.equals(str)){
            return  ;
        }
    }
}
