package com.zhuolu.leetcode.solution;

import java.util.Arrays;

public class Solution2262 {
    public long appealSum(String s) {
        long result = 0;
        long last = 0;
        int[] a = new int[26];
        Arrays.fill(a, -1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            last += i - a[index];
            result += last;

            a[index] = i;
        }
        return result;
    }
}
