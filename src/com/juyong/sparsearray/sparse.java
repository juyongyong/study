package com.juyong.sparsearray;

/**
 * @Description: 稀疏数组
 * @Author: juyong
 * @Date: 2019/12/3 18:42
 */
public class sparse {
    //存放数组中元素的个数
    static int sum = 0 ;
    public static void main(String[] args) {
        //创建一个二位数组
        int[][]array = new int[10][10];
        //给所有的元素赋值为0
       for(int i = 0 ; i <array.length ; i++){
           int[] ints = array[i];
           for(int j = 0 ; j < ints.length ; j++){
               array[i][j] = 0 ;
           }
       }
        array[1][2] = 1 ;
        array[2][4] = 2 ;

//        print(array);
        int[][] ints = transferSparseArray(array);
        print(ints);
    }
    //打印二位数组
    public static void print(int [][]array){
        for(int[] arr1:array){
            for(int arr2:arr1){
                System.out.print("\t"+arr2);
            }
            System.out.println();
        }
    }
    //把一个二位数组转为稀疏数组
    public static int[][] transferSparseArray(int [][]array){
        //遍历二位数组中，数组元素不为0的个数
        for(int[] arr1:array){
            for(int arr2:arr1){
                if(arr2 != 0) sum++ ;
            }
        }
        //创建一个二位数组代表存放稀疏数组
        int[][]sparseArray = new int[sum+1][3];
        sparseArray[0][0] = array.length ;
        sparseArray[0][1] = array[1].length;
        sparseArray[0][2] = sum ;
        int count = 0 ;
        //为稀疏数组赋值
        for(int i = 0 ; i < array.length ; i++){
            for(int j = 0 ; j<array[i].length ; j++){
                if(array[i][j]!=0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = array[i][j];
                }
            }
        }

        return sparseArray ;
    }

}
