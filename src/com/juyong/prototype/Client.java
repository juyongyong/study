package com.juyong.prototype;

/**
 * @Description: TODO
 * @Author: juyong
 * @Date: 2019/12/20 23:36
 */
public class Client {
    public static void main(String[] args) {
        Sheep sheep = new Sheep("tom",18,"white") ;
        Sheep newSheep = new Sheep("Anna",11,"green") ;
        sheep.setFriend(newSheep);

        Sheep clone1 = (Sheep) sheep.clone();
        clone1.getFriend().setName("John");
        Sheep clone2 = (Sheep) sheep.clone();
        Sheep clone3 = (Sheep) sheep.clone();
        Sheep clone4 = (Sheep) sheep.clone();
        Sheep clone5 = (Sheep) sheep.clone();

        System.out.println(clone1.hashCode()+" "+clone1);
        System.out.println(clone2.hashCode()+" "+clone2);
        System.out.println(clone3.hashCode()+" "+clone3);
        System.out.println(clone4.hashCode()+" "+clone4);
        System.out.println(clone5.hashCode()+" "+clone5);
    }
}
