package com.zhuolu.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author zhuolu
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        Map<Character, Integer> cache = new HashMap<>();
        int h = 0;
        int t = 1;
        cache.put(s.charAt(h), get(cache, s.charAt(h)) + 1);
        while (t < s.length()) {
            char hc = s.charAt(h);
            char tc = s.charAt(t);
            cache.put(tc, get(cache, tc) + 1);
            if (judge(cache)) {
                cache.put(hc, get(cache, hc) - 1);
                h++;
            }
            t++;
        }
        return t - h;
    }

    private int get(Map<Character, Integer> cache, char c) {
        Integer result = cache.get(c);
        return result == null ? 0 : result;
    }

    private boolean judge(Map<Character, Integer> cache) {
        for (Integer value : cache.values()) {
            if (value > 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("pwwkew"));
    }
}
