package com.zhuolu.leetcode.solution;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 * @author zhuolu
 */

public class Solution8 {
    public int myAtoi(String s) {
        boolean startFlag = false;
        int result = 0;
        int option = 1;
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            index++;
            if (startFlag) {
                if (!isNum(c)) {
                    return result;
                }
                int num = toNum(c);
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && num > 7)) {
                    return Integer.MAX_VALUE;
                }
                if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && num > 8)) {
                    return Integer.MIN_VALUE;
                }
                result = result * 10 + option * num;
            } else {
                if (c == '+') {
                    option = 1;
                    startFlag = true;
                } else if (c == '-'){
                    option = -1;
                    startFlag = true;
                } else if (isNum(c)) {
                    option = 1;
                    startFlag = true;
                    index--;
                } else if (c != ' ') {
                    break;
                }
            }
        }
        return result;
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    private int toNum(char c) {
        return c - '0';
    }
}
