package com.juyong.sort;

import java.util.Arrays;

/**
 * @Description: 冒泡排序
 * @Author: juyong
 * @Date: 2019/12/5 16:39
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[]array = new int[]{2,8,4,37,6,3,78,2};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[]array){
        for(int i = 0 ;i < array.length-1 ; i++){
            for(int j = i + 1 ; j<array.length ; j++){
                if(array[i]>array[j]){
                    int temp = array[i] ;
                    array[i] = array[j] ;
                    array[j] = temp ;
                }
            }
//            System.out.println("第"+i+"次排序后的结果："+Arrays.toString(array));
        }
    }
}
