package com.juyong.recursion;
/**
 * @Description: 八皇后问题
 * @Author: juyong
 * @Date: 2019/12/5 15:22
 */
public class Queen8 {
    //定义一个max表示右几个皇后
    int max  =8 ;
    //定义一个数组，表示皇后存放位置的结果
    int[]array = new int[8];
    static int count = 0 ;
    public static void main(String[] args) {
        //测试八皇后是否正确
        Queen8 queen8 = new Queen8() ;
        queen8.check(0);
        System.out.println("一共有多少中放置方案" +count+"次");
    }
    /*
     * @Author: juyong
     * @Description: 放置第n个皇后
     * @Date: 15:35 2019/12/5
     * @Param: [n] 第n个皇后
     * @return: void
     **/
    private void check(int n){
        if(n == max){ //当n=8时，表示已经放了8个皇后，这是第九个
            print();
            return ;
        }
        //一次放入皇后，并判断是否冲突
        for(int  i = 0 ; i < max ; i++){
            //先把当前这个皇后放到该行第一列
            array[n] = i ;
            //判断第n个皇后是否冲突
            if(judge(n)){//不冲突
                //不冲突就开始放n+1个皇后
                check(n+1);
            }
            //如果冲突就会执行i++,将皇后放到本行后移一个位置
        }
    }

    /*
     * @Author: juyong
     * @Description: 当我们将第n个皇后放置后，就去检测该皇后是否与之前防止的皇后是否冲突
     * @Date: 15:26 2019/12/5
     * @Param: [n] 表示第n个皇后
     * @return:  true 代表不冲突 false代表冲突
     **/
    private boolean judge(int n){

        for(int i = 0 ; i < n ; i++){
            //array[i] == array[n] 表示两个皇后是否处在一列上
            // Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示两个皇后是否处在一条斜线上
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false ;
            }
        }
        return true ;
    }
    /*
     * @Author: juyong
     * @Description: 打印皇后的摆放结果
     * @Date: 15:24 2019/12/5
     * @Param: []
     * @return: void
     **/
    public void print(){
        for(int i = 0 ; i < array.length ; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
        count++ ;
    }
}
