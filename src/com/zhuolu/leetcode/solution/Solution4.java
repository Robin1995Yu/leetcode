package com.zhuolu.leetcode.solution;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * @author zhuolu
 */

public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int center1 = length >> 2;
        int center2 = center1;
        if ((length & 1) == 0) {
            center2++;
        }
        return 0;
    }
}
