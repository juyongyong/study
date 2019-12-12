package com.juyong.sort;

import java.util.Arrays;

/**
 * @Description: 归并排序：归并排序是利用归并的思想实现的排序方法，该算法采用分治策略（分治法
 * 将问题分为一些小的问题然后递归求解，而治的阶段则将分的阶段得到的各答案修补在一起，即分儿治之）
 * @Author: juyong
 * @Date: 2019/12/10 13:35
 */
public class MergeSort {

    public static void main(String[] args) {

        int[]array =new int[]{1,3,5,2,4,6,8,10};
        System.out.println(Arrays.toString(array));
//        sort(array, 0,3,array.length - 1);
        mergeSort(array,0,array.length - 1);
        System.out.println(Arrays.toString(array));

    }

    public static void mergeSort(int[]array,int low ,int high){
        int middle = (low + high)/2 ;
        if(low < high) {
            //处理左边
            mergeSort(array, low, middle);
            //处理右边
            mergeSort(array, middle + 1, high);
            //归并
            sort(array, low, middle, high);
        }
    }
    /*
     * @Author: juyong
     * @Description: 归并排序的实现
     * @Date: 22:40 2019/12/11
     * @Param: [需要排序的数组, 排序数组的低位, 排序数组的中间位置, 排序数组的高位]
     * @return: void
     **/
    public static void sort(int[]array,int low,int middle,int high){
        //用于存储归并后的零时数组
        int[]temp = new int[high - low + 1];
        //记录第一个数组中需要遍历的下标
        int i = low ;
        //记录第二个数组中需要遍历的下标
        int j = middle + 1 ;
        //用于记录在零时数组中存放的下表
        int index = 0 ;
        //遍历两个数组取出小的数字放入零时数组中
        while(i <= middle && j <= high){
           if(array[i] <=  array[j]){
               //把小的数据放入到零时数组中
                temp[index] = array[i] ;
               //然后下标后移一位
                i++ ;
           }else{
               //把小的数据放入到零时数组中
               temp[index] = array[j] ;
               //然后下标后移一位
               j++ ;
           }
           index++ ;
        }

        //处理多余的数据
        while(j <= high){//第二个数组多数据
            temp[index] = array[j] ;
            j++ ;
            index++ ;
        }
        while(i <= middle){//第一个数组多数据
            temp[index] = array[i] ;
            i++ ;
            index++ ;
        }
        //把临时数组的数据重新存入到原数组中
        for(int k = 0 ; k < temp.length ; k++ ){
            array[k + low] = temp[k] ;
        }

    }
}
