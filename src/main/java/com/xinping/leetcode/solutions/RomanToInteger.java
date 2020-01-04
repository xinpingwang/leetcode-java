package com.xinping.leetcode.solutions;

import java.util.HashMap;

public class RomanToInteger {

    /**
     * Hash 表
     * <p>
     * 9ms, 58.63%
     */
    public int romanToInt(String s) {
        HashMap<Character, Integer> valueMap = new HashMap<>();
        valueMap.put('I', 1);
        valueMap.put('V', 5);
        valueMap.put('X', 10);
        valueMap.put('L', 50);
        valueMap.put('C', 100);
        valueMap.put('D', 500);
        valueMap.put('M', 1000);

        int strLen = s.length();
        int result = 0;
        for (int i = 0; i < strLen; i++) {
            if (i + 1 < strLen && valueMap.get(s.charAt(i)) < valueMap.get(s.charAt(i + 1))) {
                result += valueMap.get(s.charAt(i + 1)) - valueMap.get(s.charAt(i));
                i++;
            } else {
                result += valueMap.get(s.charAt(i));
            }
        }
        return result;
    }
}
