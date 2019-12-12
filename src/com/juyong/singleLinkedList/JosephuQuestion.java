package com.juyong.singleLinkedList;

/**
 * @Description: 约瑟夫问题
 * @Author: juyong
 * @Date: 2019/12/12 16:35
 */
public class JosephuQuestion {

    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList() ;
        list.addBoy(5);
//        list.showBoy();
        list.countBoy(1,2,5);
    }
}
//创建一个环形的单向链表
class CircleSingleLinkedList{
    //创建一个first节点，当前节点没有编号
    private Boy first = new Boy(-1) ;
    //添加小孩节点构成一个环形链表
    public void addBoy(int no){
        //做一个数据校验，如果no< 1,就return
        if(no < 1) return;
        //使用for循环创建 环形链表
        Boy curr = null ;//辅助指针，帮助构建环形链表
        for(int i = 1 ; i <= no ; i++){
            Boy boy = new Boy(i) ;
            if(i == 1){
                first = boy ;
                first.setNext(boy);
                curr = first ;
            }else{
                curr.setNext(boy);
                boy.setNext(first);
                curr = boy ;
            }
        }
    }
    //遍历当前环形链表
    public void showBoy(){
        //判断链表是否为空
        if(first == null){
            System.out.println("此链表为空");
            return ;
        }
        //因为first不能动，因此我们任然会使用一个辅助指针来完成遍历
        Boy curr = first ;
        while(true){
            System.out.println("小孩子的编号"+curr.getNo());
            if(curr.getNext() == first){
                break ;
            }
            curr = curr.getNext() ;//curr后移
        }
    }
    /*
     * @Author: juyong
     * @Description: 
     * @Date: 18:14 2019/12/12
     * @Param: [startNo 从第几个小孩开始数数, countNum 表示数几下, nums 表示最初有多少小孩在圈中]
     * @return: void
     **/
    public void countBoy(int startNo,int countNum , int nums){
        if(first == null || startNo < 1 || startNo > nums){
            System.out.println("输入的参数有误，请重新输入");
            return ;
        }
        //创建需要的帮助指针
        Boy helper = first ;
        //需求创建一个指针遍历helper，事先应该指向环形链表的最后一个节点
        while(true){
            if(helper.getNext() == first) break;
            helper = helper.getNext() ;
        }
        //小孩报数前，先让first和helper移动k-1次
        for(int j = 0 ; j < startNo -1 ; j++){
            first = first.getNext() ;
            helper = helper.getNext() ;
        }
        //当小孩报数时，让first和helper指针同时移动 m - 1 次，然后出圈
        //这里是一个循环操作，直到圈中只有一个节点
        while(helper != first){
            for(int j = 0 ; j <countNum -1 ; j++){
                first = first.getNext() ;
                helper = helper.getNext() ;
            }
            //这时first指向的节点就是要出圈的节点
            System.out.println("小孩的编号:"+first.getNo());
            //这时将first指向小孩出圈的节点
            first = first.getNext() ;
            helper.setNext(first);
        }
        System.out.println("最后一个小孩的节点:"+first.getNo());
    }
}

//创建一个Boy类表示一个节点
class Boy{
    private int no ;//编号
    private Boy next ; //指向下一个节点，默认为null

    public Boy(int  no) {
       this.no = no ;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
