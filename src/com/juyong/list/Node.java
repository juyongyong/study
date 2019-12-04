package com.juyong.list;

/**
 * @Description: 节点
 * @Author: juyong
 * @Date: 2019/12/3 19:01
 */

public class Node {
    private Node previous ;
    private int data ;
    private Node next ;

    public Node() {
    }

    public Node(Node previous, int data, Node next) {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data+"" ;
    }
}
