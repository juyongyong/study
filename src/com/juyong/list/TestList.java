package com.juyong.list;

/**
 * @Description: TODO
 * @Author: juyong
 * @Date: 2019/12/3 19:06
 */
public class TestList {
    public static void main(String[] args) throws Exception {
        MyArrayList list = new MyArrayList() ;
        list.add(100);
        list.add(20);
        list.add(20);
        list.add(20);
        list.add(20);
        list.add(20);
        System.out.println(list.size());
        System.out.println(list.get(0));
        list.remove(0);
        list.remove(2);
        list.print();

    }
}
