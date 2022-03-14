package com.zhuolu.leetcode.solution;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 * @author zhuolu
 */

public class Solution7 {

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) {
                return 0;
            }
            result = result * 10 +  x % 10;
            x /= 10;
        }
        return result;
    }
}
