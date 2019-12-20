package com.juyong.leetcode;

/**
 * @Description: 两个数组求中位数
 * @Author: juyong
 * @Date: 2019/12/19 21:28
 */
public class MediaWithTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {3,5,8,9,10};
        int[] nums2= {1,2,7,10,11,12};
        double median = getMedian(nums1, nums2);
        System.out.println(median);
        //1,2,3,5,7,8,9,10,10,11,12
    }

    public static double getMedian(int[]nums1,int[]nums2){
        if(nums1.length > nums2.length){
            return getMedian(nums2,nums1) ;
        }
        int N1 = nums1.length ;
        int N2 = nums2.length ;
        if(N1 == 0){
            return ((double)nums2[(N2 - 1)/2] + (double)nums2[N2/2])/2 ;
        }
        int size = N1 + N2 ;
        int cutL = 0,cutR = N1 ;
        int cut1 = N1/2 ;
        int cut2  ;

        while(cut1 <= N1){
            cut1 = (cutR + cutL)/2 + cutL ;
            cut2 = size/2 - cut1 ;
            double L1 = (cut1 == 0 )?Integer.MIN_VALUE:nums1[cut1 - 1] ;
            double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1] ;
            double R1 = (cut1 == N1) ? Integer.MAX_VALUE : nums1[cut1] ;
            double R2 = (cut2 == N2) ? Integer.MAX_VALUE : nums2[cut2] ;

            if(L1 > R2){
                cutL =cutL - 1 ;
            }else if(L2 > R1){
                cutR = cutR + 1 ;
            }else{
                if(size % 2 == 0){
                    L1 = L1 > L2 ? L1 : L2 ;
                    R1 = R1 > R2 ? R2 : R1 ;
                    return (L1 + R1)/2 ;
                }else{
                    return R1 > R2 ? R2 : R1 ;
                }

            }
        }
        return -1;
    }

}
