package com.juyong.sort;

import java.util.Arrays;

/**
 * @Description: TODO
 * @Author: juyong
 * @Date: 2019/12/12 18:58
 */
public class RadisSort1 {

    public static void main(String[] args) {
        int[]array = {2,1,37,12,67,4,126,8,7} ;
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[]array){
        int[][]bucket = new int[10][array.length];
        int[]bucketElement = new int[10] ;
        int min = array[0];
        for(int i = 1 ;i < array.length ; i++){
            if(min < array[i]){
                min = array[i];
            }
        }
        String maxString = min+"" ;
        for(int i = 0,n=1 ; i < maxString.length() ; i++,n*=10){
            for(int j = 0 ; j < array.length ; j++){
                int digitElement = array[j]/n%10 ;
                bucket[digitElement][bucketElement[digitElement]++] = array[j];
            }
            int index = 0 ;
            for(int k = 0 ; k < bucket.length ; k++){
                if(bucketElement[k] > 0){
                    for(int m = 0 ; m < bucketElement[k] ; m++){
                        array[index++] = bucket[k][m] ;
                    }
                }
                bucketElement[k] = 0 ;
            }
            index = 0 ;
        }

    }
}
