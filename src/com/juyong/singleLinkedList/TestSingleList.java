package com.juyong.singleLinkedList;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: juyong
 * @Date: 2019/12/4 12:07
 */
public class TestSingleList {
    public static void main(String[] args) throws Exception {
        SingleList list = new SingleList() ;
        list.add(new Node(1,"琚咏sb","套死你猴子"));
        list.add(new Node(2,"琚咏","牛逼"));
        list.add(new Node(3,"琚咏","牛逼"));
        list.add(new Node(4,"琚咏","牛逼"));
        list.add(new Node(5,"琚咏","牛逼"),3);
        list.print(list);
        System.out.println(list.get(3));
//        System.out.println(list.size()) ;
//        System.out.println(list.getFirst());
//        System.out.println(list.getLast());



    }
}
