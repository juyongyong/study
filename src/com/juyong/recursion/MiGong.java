package com.juyong.recursion;

import jdk.jfr.Description;

/**
 * @Description: 迷宫问题
 * @Author: juyong
 * @Date: 2019/12/5 14:19
 */
public class MiGong {
    public static void main(String[] args) {
        //创建一个二位数组表示地图
        int[][]map =new int[8][7];
        //用1表示墙
        init(map);//调用初始化方法初始化地图
        print(map);
        System.out.println();
        System.out.println();
        setWay(map,1,1) ;
        print(map);
    }
    /*
     * @Author: juyong
     * @Description: 使用递归回溯给小球找路
     * @Date: 14:59 2019/12/5
     * @Param: map 表示地图
     * @Param: i,j 表示从哪开始找
     * @return: 如果找到通路返回true，否则返回false
     **/
    //如果小球能到map[6][5]位置则说明通路找到
    //约定map[i][j] = 0表示该点没有走过，1表示是墙，2表示可以走，3表示该点已经走过但是不通
    //在走迷宫时，需要确定一个策略，按下、右、上、左走
    public static boolean setWay(int[][]map,int i,int j){
        if(map[map.length-2][map[0].length-2] == 2){
            return true ;
        }else{
            if(map[i][j] == 0){//如果当前这个点没有走过
                //按照策略下、右、上、左走
                map[i][j] = 2 ;//假定该点可以走通
                if(setWay(map,i+1,j)){//向下走
                    return true ;
                }else if(setWay(map,i,j+1)){//向右走
                    return true ;
                }else if(setWay(map,i-1,j)){//向上走
                    return true ;
                }else if(setWay(map,i,j-1)){//向左走
                    return true ;
                }else{
                    map[i][j] = 3 ;//说明该点是走不通的，置为3；
                    return false ;
                }
            }else{//如果map[i][j]=1、2、3表示不能走了
                return false ;
            }
        }
    }
    //初始化地图
    public static void init(int[][]map){
       //获取行和列
        int hang = map.length ;
        int lie = map[0].length ;
        for(int i = 0 ; i < hang ; i++){
            map[i][0] = 1 ;
            map[i][lie-1] = 1;
        }
        for(int i = 0 ; i < lie ; i++){
            map[0][i] = 1 ;
            map[hang-1][i] = 1;
        }
        map[3][1] = 1 ;
        map[3][2] = 1 ;
        map[4][4] = 1 ;
    }
    //打印地图
    public static void print(int[][]map){
        for(int i = 0 ; i < map.length ; i++){
            for(int j = 0 ; j < map[i].length ; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }


}
