package com.xinping.leetcode.solutions;

public class ReverseWordsInAStringIII {

    /**
     * 注意最后一个单词的处理
     * <p>
     * 5ms, 92.22%
     */
    public String reverseWords(String s) {

        char[] chars = s.toCharArray();

        int start = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ' || i == chars.length - 1) {
                int l = start, r = i == chars.length - 1 ? i : i - 1;
                while (l < r) {
                    char tmp = chars[l];
                    chars[l] = chars[r];
                    chars[r] = tmp;
                    l++;
                    r--;
                }
                start = i + 1;
            }
        }

        return String.valueOf(chars);
    }
}
