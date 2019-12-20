package com.juyong.prototype;

/**
 * @Description: TODO
 * @Author: juyong
 * @Date: 2019/12/21 00:19
 */
public class ClientDeepClone {
    public static void main(String[] args) throws Exception{
        DeepPrototype prototype = new DeepPrototype() ;
        prototype.setName("宋江");
        prototype.setDeepClone(new DeepClone("大牛","大牛的类"));

        DeepPrototype clone1 = (DeepPrototype)prototype.deepClone();
        System.out.println(prototype.getDeepClone().hashCode() +":"+clone1.getDeepClone().hashCode());
        System.out.println(prototype);
        System.out.println(clone1);
    }
}
