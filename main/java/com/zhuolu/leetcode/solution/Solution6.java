package com.zhuolu.leetcode.solution;

public class Solution6 {
    public String convert(String s, int numRows) {
        if (s.length() == numRows || numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.length());
        int base = (numRows << 1) - 2;
        for (int i = 0; i < numRows; i++) {
            int flag = 0;
            int[] steeps = new int[2];
            int i1 = base - (i << 1);
            int i2 = i << 1;
            steeps[0] = i1 == 0 ? base : i1;
            steeps[1] = i2 == 0 ? base : i2;
            int curr = i;
            while (curr < s.length()) {
                sb.append(s.charAt(curr));
                curr += steeps[flag];
                flag ^= 1;
            }
        }
        return sb.toString();
    }
}
