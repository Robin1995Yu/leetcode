package com.zhuolu.leetcode.solution;

import java.util.Iterator;
import java.util.Stack;

public class Solution224 {
    public int calculate(String s) {
        It it = new It(s);
        Stack<Object> stack = new Stack<>();
        return 0;
    }

    private static class It implements Iterator<String> {

        private final String s;
        private int index = 0;

        private It(String s) {
            this.s = s;
            moveToNextNotBlank();
        }

        @Override
        public boolean hasNext() {
            return index < s.length();
        }

        @Override
        public String next() {
            char c = s.charAt(index);
            if (c >= '0' && c <= '9') {
                int end = index + 1;
                while (end < s.length() && s.charAt(end) >= '0' && s.charAt(end) <= '9') {
                    end++;
                }
                int start = index;
                index = end;
                moveToNextNotBlank();
                return s.substring(start, end);
            } else {
                index++;
                moveToNextNotBlank();
                return String.valueOf(c);
            }
        }

        private void moveToNextNotBlank() {
            while (index < s.length() && s.charAt(index) == ' ') {
                index++;
            }
        }
    }
}
