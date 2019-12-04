package com.juyong.singleLinkedList;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description: 单向链表
 * @Author: juyong
 * @Date: 2019/12/4 12:02
 */
public class SingleList {
    private Node head ;
    private int size = 0 ;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //初始化头节点
    public SingleList(){
        head = new Node();
        head.setNext(null);

    }
    //插入指定位置
    public void add(Node node,int index) throws Exception {
        Node temp = head ;
        int count = 0 ;
        node.setNext(get(index));
        while(true){
            if(temp.getNext() == null){
                break ;
            }else{
                if(count == index){
                    temp.setNext(node);
                    break;
                }
                count++ ;
                temp=temp.getNext();
            }
        }
    }
    //获取指定位置的元素
    public Node get(int index){
        if(index == 0){
            return head.getNext();
        }
        int count = 0 ;
        Node first = head.getNext() ;
        while(first != null){
            first = first.getNext() ;
            count++;
            if(count == index){
                return first ;
            }
        }
        return null ;
    }
    //获取最后一个元素
    public Node getLast(){
        Node temp = head.getNext();
        if(temp == null){
            return null ;
        }
        while(temp.getNext() != null){
            temp = temp.getNext() ;
        }
        return temp ;
    }

    //获取第一个元素
    public Node getFirst(){
       return head.getNext();
    }

    //获取链表元素个数
    public int size(){
        return this.size;
    }
    //新增节点,默认加载最后
    public void add(Node node){
        if(size == 0){
            head.setNext(node);
            size++ ;
            return ;
        }
        Node last = getLast();
        last.setNext(node);
        size++ ;
    }

    //打印
    public void print(SingleList list){
        Node node = list.getHead();
        while(node.getNext()!=null){
            node = node.getNext() ;
            System.out.println(node.getNo()+"\t"+node.getName()+"\t"+node.getNickName());

        }
    }

}
