package com.juyong.list;

import java.util.Arrays;

/**
 * @Description: TODO
 * @Author: juyong
 * @Date: 2019/12/3 19:12
 */
public class test1 {
    public static void main(String[] args) {
        int []array = new int[]{11,23,1,212,3,1,1};
        array = Arrays.copyOf(array,10);
        System.out.println(array.length);
        System.arraycopy(array,3,array,2,6);
        System.out.println(Arrays.toString(array));
    }
}
