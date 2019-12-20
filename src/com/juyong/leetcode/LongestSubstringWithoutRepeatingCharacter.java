package com.juyong.leetcode;

import java.util.*;

/**
 * @Description: 获取最大不重复子字符串
 * @Author: juyong
 * @Date: 2019/12/19 20:46
 */
public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        String str =  "aqqqsg" ;
        int i = lengthOfLongestSubStringByMap(str);
        System.out.println("i = "+i);
        int i1 = lengthOfLongestSubstringBySet(str) ;
        System.out.println("i1 = "+ i1);
    }

    //方法一
    public static int  lengthOfLongestSubStringByMap(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        Map<Character,Integer> map = new HashMap<>() ;
        int res = 0 ;
        String str = "" ;
        for(int i = 0 ,j = 0 ; i < s.length() ; i++){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1) ;
            }
            if(res < i - j + 1){
                str = s.substring(j,i+1 ) ;
            }
            map.put(s.charAt(i),i) ;
            res = Math.max(res,i - j + 1) ;
        }
        System.out.println(str);
        return res ;
    }

    //方法二
    public static int lengthOfLongestSubstringBySet(String str){
        if(str == null || str.length() == 0){
            return -1 ;
        }
        Set<Character> set = new HashSet<>() ;
        int res = 0 ;
        for(int i = 0 ,j = 0; i < str.length() ; i++ ){
            if(set.contains(str.charAt(i))){
                set.remove(str.charAt(i));
            }else{
                set.add(str.charAt(i)) ;
                res = Math.max(res,set.size()) ;
            }
        }
        return res ;
    }

}
