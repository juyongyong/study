package com.juyong.sort;

import java.util.Arrays;

/**
 * @Description: 基数排序 * @Author: juyong
 * @Date: 2019/12/12 15:34
 */
//基数排序属于“分配式排序”，又称为桶子法，顾名思义，他是通过键值的各个位的值，将要排序的元素分配至某些桶中，达到排序的作用
//基数排序属于稳定性排序，基数排序的是效率高的稳定性排序法
// 基数排序是桶排序的扩展
//基数排序的实现是将整数按位数切割成不同的数字，然后按每个位数分别比较
public class RadixSort {
    public static void main(String[] args) {
        int[]array = {2,38,746,23,7,847,82,3} ;
//        sort(array);
        radixSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void radixSort(int[]array){
        //定义一个桶
        int[][]bucket = new int[10][array.length];
        //获取最大位数
        int max = array[0] ;
        for(int  i = 1 ; i < array.length ; i++){
            if(max < array[i]) max = array[i] ;
        }
        String maxLength = max+"" ;
        //每个桶中数据的数量
        int[]bucketElementCount = new int[10] ;
        //根据最大位数来进行循环
        int element = 0 ;
        int index = 0 ;
        for(int i = 1 ,n = 1 ; i <= maxLength.length() ; i++,n*=10){
            //遍历数组
            for(int j = 0 ; j < array.length ; j++){
                element = array[j]/n%10 ;
                bucket[element][bucketElementCount[element]++] = array[j] ;
            }

            //把桶中的数据重新取出
            for(int k = 0 ; k < bucket.length ; k++){
                if(bucketElementCount[k] > 0 ){
                    for(int m = 0 ; m < bucketElementCount[k] ; m++){
                        array[index++] = bucket[k][m] ;
                    }
                }
                bucketElementCount[k] = 0 ;
            }
            index = 0 ;
            System.out.println(Arrays.toString(array));
        }

    }

    public static void sort(int[] array){
        //第一轮排序(针对每个元素的个位数排序)
        //定义一个二维数组表示十个桶,每个桶代表一个一维数组
        int[][]bucket = new int[10][array.length];

        //为了记录每个桶存放了多少个数据，我们定义一个一维数组来记录各个桶每次放入数据的个数
        int[]bucketElementCount = new int[10];
        //第一轮
        for(int i = 0 ; i < array.length ; i++){
            int digitOfElement = array[i]%10 ;
            bucket[digitOfElement][bucketElementCount[digitOfElement]++] = array[i] ;
        }
        int index = 0 ;
        //按照这个桶的顺序取出数据放入原数组
        for(int i = 0 ; i < 10 ; i++){
            if(bucketElementCount[i] > 0){
                for(int j = 0 ; j < bucketElementCount[i] ; j++){
                    //取出元素放入到array中
                    array[index++] = bucket[i][j];
                }
            }
            bucketElementCount[i] = 0 ;
        }
        System.out.println(Arrays.toString(array));
        //第二轮
        index = 0 ;
        for(int i = 0 ; i < array.length ; i++){
            int digitOfElement = array[i]/10%10 ;
            bucket[digitOfElement][bucketElementCount[digitOfElement]++] = array[i] ;
        }
        //按照这个桶的顺序取出数据放入原数组
        for(int i = 0 ; i < 10 ; i++){
            if(bucketElementCount[i] > 0){
                for(int j = 0 ; j < bucketElementCount[i] ; j++){
                    //取出元素放入到array中
                    array[index++] = bucket[i][j];
                }
            }
            bucketElementCount[i] = 0 ;
        }
        System.out.println(Arrays.toString(array));
        //第三轮
        index = 0 ;
        for(int i = 0 ; i < array.length ; i++){
            int digitOfElement = array[i]/100%10 ;
            bucket[digitOfElement][bucketElementCount[digitOfElement]++] = array[i] ;
        }
        //按照这个桶的顺序取出数据放入原数组
        for(int i = 0 ; i < 10 ; i++){
            if(bucketElementCount[i] > 0){
                for(int j = 0 ; j < bucketElementCount[i] ; j++){
                    //取出元素放入到array中
                    array[index++] = bucket[i][j];
                }
            }
            bucketElementCount[i] = 0 ;
        }
        System.out.println(Arrays.toString(array));


    }
}
