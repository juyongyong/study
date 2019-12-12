package com.juyong.sort;

import java.util.Arrays;

/**
 * @Description: 快速排序
 * @Author: juyong
 * @Date: 2019/12/9 21:11
 */
public class QuickSort {
    public static void main(String[] args) {
        int[]array ={11,32,4,67,8,2,36,47,81,3,9};
        sort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
    /*
     * @Author: juyong
     * @Description: 快速排序实现
     * @Date: 21:12 2019/12/9
     * @Param: [待排序的数组, 开始位置, 结束位置]
     * @return: void
     **/
    public static void sort(int[]array,int start, int end) {
        if (start < end) {
            //默认取第一个数作为标准
            int stard = array[start];
            //记录下表
            int low = start;
            int high = end;

            //循环找比标准大的数和比标准小的数
            while (low < high) {
                //如果右边的数比标准小标准数就不变，右边下标移动
                while (low < high && stard <= array[high]) {
                    high--;
                }
                //右边的数比标准的数大
                array[low] = array[high];

                //左边的数如果比标准数小则不做处理
                while (low < high && stard >= array[low]) {
                    low++;
                }
                array[high] = array[low];
            }
            array[low] = stard;
            //处理比标准小的数
            sort(array, start, low);
            //处理比标准大的位置
            sort(array, low+1, end);

        }
    }
}
