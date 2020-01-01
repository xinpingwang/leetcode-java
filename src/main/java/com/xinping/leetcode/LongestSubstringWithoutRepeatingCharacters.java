package com.xinping.leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * 从第 2 个字母开始，一次将当前字母添加到最长子串中，同时检测当前子串中有没有和最后一个自负重复的，
     * 如果有，则将重复字符前面（包含）的从子串中剔除出去。
     * <p>
     * 3 ms, 97.06%
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        int start = 0, end = 1, maxLength = 1;

        for (int i = 1; i < s.length(); i++) {
            int repeatIndex = -1;
            for (int j = start; j < end; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    repeatIndex = j;
                    break;
                }
            }
            if (repeatIndex >= 0) {
                start = repeatIndex + 1;
            }
            end = i + 1;
            maxLength = Math.max(maxLength, end - start);
        }

        return maxLength;
    }

    /**
     * 通过 HashMap 来记录不重复的字符和其最后出现的位置：
     * 当遇到新的字符已经存在于 HashMap 的 Keys 中时，记 HashMap 中该字符的索引，同时计算最新的最大长度。
     * <p>
     * 11ms, 71.12%
     */
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length(), ans = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }

        return ans;
    }
}
