package com.juyong.prototype;

/**
 * @Description: 克隆羊类
 * @Author: juyong
 * @Date: 2019/12/20 23:12
 */
public class Sheep implements Cloneable{

    private String name ;
    private int age ;
    private String color ;
    private Sheep friend ;

    public Sheep() {
    }

    public Sheep(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    protected Object clone() {
        Sheep sheep = null ;
        try {
            sheep = (Sheep)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return sheep ;
    }

    public Sheep getFriend() {
        return friend;
    }

    public void setFriend(Sheep friend) {
        this.friend = friend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        int hashcode = 0 ;
        if(friend != null) {
             hashcode = friend.hashCode();
        }
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", friend=" + friend +
                '}'+hashcode;
    }
}
