package com.juyong.simplefactory.pizza;

/**
 * @Description: TODO
 * @Author: juyong
 * @Date: 2019/12/18 15:56
 */
public abstract class Pizza {
    protected String name ;//名字

    public Pizza(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void prepare();
    //烤焙
    public void bake(){
        System.out.println(name+" baking.....");
    }
    //切
    public void cut(){
        System.out.println(name+" cutting.....");
    }
    //打包
    public void box(){
        System.out.println(name+" boxing......");
    }
}
