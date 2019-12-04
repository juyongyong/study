package com.juyong.list;

import java.util.Arrays;

/**
 * @Description: 自定义列表
 * @Author: juyong
 * @Date: 2019/12/3 19:01
 */
public class MyArrayList {
    private Node[] nodes ;
    private int size ;
    private int length ;


    public MyArrayList() {
        nodes = new Node[10];
    }
    public MyArrayList(int length) throws Exception {
        if(length <= 0) throw new Exception() ;
        nodes = new Node[length] ;
    }
    //添加元素
    public void add(int data){
        //先判断数组的长度是否足够
        if(this.size+2>nodes.length){
            this.nodes = Arrays.copyOf(this.nodes,nodes.length*2+1);
        }
        nodes[size] = new Node(data);
        size++ ;
    }
    //根据下标取元素
    public int get(int index) throws Exception {
        if(index >= size){
            throw new Exception();
        }
        return nodes[index].getData();
    }
    //删除元素
    public void remove(int index) throws Exception {
        if(index >= size) throw new Exception();
//        this.nodes = System.arraycopy();
        System.arraycopy(this.nodes,index+1,this.nodes,index,size-index);
        size-- ;
    }
    public void print(){
//        System.out.println(Arrays.toString(nodes));
        for(Node node:nodes){
            if(node != null) System.out.print(node.getData()+"\t");
        }
    }



    //返回列表的长度
    public  int size(){
        return this.size ;
    }

    public Node[] getNodes() {
        return nodes;
    }

    public void setNodes(Node[] nodes) {
        this.nodes = nodes;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
