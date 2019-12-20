package com.juyong.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:两个数相加的问题
 * @Author: juyong
 * @Date: 2019/12/19 19:57
 */
public class TwoNumAdd {
    public static int[] twoNumsAdd(int[]nums,int target){
        int length = 2 ;
        if(nums == null || nums.length < length){
            return new int[]{-1,-1};
        }
        int []res = new int[]{-1,-1};
        Map<Integer,Integer> map = new HashMap<>(nums.length) ;
        for(int i = 0 ; i < nums.length ; i++){
            if(map.containsKey(target - nums[i])){
                res[0] = map.get(target - nums[i]);
                res[1] = i ;
                break ;
            }
            map.put(nums[i],i) ;
        }
        return res ;
    }

    public static void main(String[] args) {
        int[] array = new int[]{22,7,1,2,1,19};
        int[] ints = twoNumsAdd(array, 9);
        System.out.println(Arrays.toString(ints));

    }
}
