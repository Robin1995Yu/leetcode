package com.zhuolu.leetcode.solution;

public class Solution1_2 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        byte[] counts = new byte[26];
        for (char c : s1.toCharArray()) {
            counts[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            counts[c - 'a']++;
        }
        for (byte count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
