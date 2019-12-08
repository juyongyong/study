package com.juyong.sort;

import java.util.Arrays;

/**
 * @Description: 希尔排序
 * @Author: juyong
 * @Date: 2019/12/6 11:12
 */
public class ShellSort {
    public static void main(String[] args) {
        int []array = new int[]{2,64,3,7,8,2,36,4,9,2};
//        sort(array);
        sort1(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[]array){
        int temp = 0 ;
        for(int i = array.length/2 ; i >= 1 ; i/=2){//确定步长，第一次的步长为length/2，之后每次除2
            for(int j = i ; j < array.length ; j++){
                for(int k = j - i ; k >= 0 ; k-=i){
                    if(array[k] > array[k + i]){
                        temp = array[k];
                        array[k] = array[k+i];
                        array[k+i] =temp ;
                    }
                }
            }
            System.out.println("第"+i+"轮排序后的结果："+Arrays.toString(array));
        }
    }
    /*
     * @Author: juyong
     * @Description: 增强版希尔排序
     * @Date: 12:08 2019/12/6
     * @Param: [array]
     * @return: void
     **/
    public static void sort1(int[]array){
        for(int grap = array.length / 2 ; grap >= 1 ; grap /= 2){
            for(int i = grap ; i < array.length ; i++){
                int j = i;
                int temp =array[j] ;
                while (j - grap >= 0 && temp < array[j - grap]) {
                    array[j] = array[j - grap];
                    j -= grap;
                }
                //当推出while循环后就给temp找到了插入位置
                array[j] = temp ;
            }
        }
    }
}
