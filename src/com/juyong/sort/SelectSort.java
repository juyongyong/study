package com.juyong.sort;

import java.util.Arrays;

/**
 * @Description: 选择排序
 * @Author: juyong
 * @Date: 2019/12/5 16:52
 */
public class SelectSort {
    public static void main(String[] args) {
        int[]array = new int[]{27,3,48,7,3,26,4,7};
//        sort(array);
        //测试八万个数据
        int[]arr = new int[80000];
        for(int i  = 0 ; i < 80000 ; i++){
            arr[i] = (int)(Math.random()*80000);
        }
        long start = System.currentTimeMillis();
        //使用选择排序
        sort(arr);
        //使用冒泡排序
//        BubbleSort.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end -start);
        System.out.println(Arrays.toString(arr));

    }
    /*
     * @Author: juyong
     * @Description: 选择排序一共有length-1轮排序
     * 每一轮排序，是一个循环
     * @Date: 16:55 2019/12/5
     * @Param: [args]
     * @return: void
     **/
    public static void sort(int[]array){
        for(int i = 0 ; i < array.length-1 ; i++){
            int minIndex = i ;
            int min = array[i];
            for(int j = i + 1 ; j < array.length ; j++){
                if(min > array[j]){
                    minIndex = j ;
                    min = array[j];
                }
            }
            array[minIndex] = array[i];
            array[i] = min ;
        }
    }
}
