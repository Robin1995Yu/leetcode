package com.zhuolu.leetcode.solution;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @author zhuolu
 */

public class Solution5 {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int sResult = 0;
        int eResult = 0;
        for (int i = 0; i < s.length(); i++) {
            int s1 = i;
            int e1 = i;
            int s2 = i;
            int e2 = i + 1;
            while (s1 >= 0 && e1 < s.length() && s.charAt(s1) == s.charAt(e1)) {
                s1--;
                e1++;
            }
            while (s2 >= 0 && e2 < s.length() && s.charAt(s2) == s.charAt(e2)) {
                s2--;
                e2++;
            }
            s1++;
            e1--;
            s2++;
            e2--;
            int length1 = e1 - s1;
            int length2 = e2 - s2;
            int lengthTemp = length1 > length2 ? length1 : length2;
            int sTemp = length1 > length2 ? s1 : s2;
            int eTemp = length1 > length2 ? e1 : e2;
            int length = eResult - sResult;
            sResult = length > lengthTemp ? sResult : sTemp;
            eResult = length > lengthTemp ? eResult : eTemp;
        }
        return s.substring(sResult, eResult + 1);
    }
}