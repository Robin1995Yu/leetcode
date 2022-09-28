package com.zhuolu.leetcode.solution;

public class Solution11 {
    public int maxArea(int[] height) {
        int s = 0;
        int e = height.length - 1;
        int max = 0;
        while (e > s) {
            max = Integer.max(max, (e - s) * Integer.min(height[s], height[e]));
            if (height[e] > height[s]) {
                s++;
            } else {
                e--;
            }
        }
        return max;
    }
}
