package com.juyong.sort;

import java.util.Arrays;

/**
 * @Description: 插入排序
 * @Author: juyong
 * @Date: 2019/12/5 18:17
 */
public class InsertSort {
    public static void main(String[] args) {
        int[]array = new int[]{2,34,8,72,38,47,2,8};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
    /*
     * @Author: juyong
     * @Description: 插入排序
     * @Date: 18:18 2019/12/5
     * @Param: []
     * @return: void
     **/
    public static void sort(int[]array){
        for(int i = 0 ; i < array.length - 1 ; i++){
            int insertVal = array[i+1];
            int insertIndex = i ;
            //如果后面的数比前面的数小，则交换位置。
            while(insertIndex >= 0 && insertVal < array[insertIndex]){
                array[insertIndex+1] = array[insertIndex] ;
                insertIndex-- ;
            }
            array[insertIndex+1] = insertVal ;
            System.out.println("第"+i+"轮排序后的结果："+Arrays.toString(array));
        }
    }
}
