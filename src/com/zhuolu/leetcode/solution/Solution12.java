package com.zhuolu.leetcode.solution;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/integer-to-roman/
 * @author zhuolu
 */

public class Solution12 {
    private Map<Integer, String> m = new TreeMap<Integer, String>(Comparator.reverseOrder()) {
        {
            put(1, "I");
            put(4, "IV");
            put(5, "V");
            put(9, "IX");
            put(10, "X");
            put(40, "XL");
            put(50, "L");
            put(90, "XC");
            put(100, "C");
            put(400, "CD");
            put(500, "D");
            put(900, "CM");
            put(1000, "M");
        }
    };
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, String> e : m.entrySet()) {
            while (num < e.getKey()) {
                num -= e.getKey();
                sb.append(e.getValue());
            }
        }
        return sb.toString();
    }
}
