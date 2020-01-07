package com.xinping.leetcode.solutions;

import java.util.HashMap;
import java.util.Stack;

public class LongestValidParentheses {

    /**
     * 暴力法
     * <p>
     * 超时
     */
    public int longestValidParentheses(String s) {
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            // 排除闭括号开始的情况
            if (s.charAt(i) == ')') {
                continue;
            }
            // 有效的括号长度一定是偶数，并且，需要检查的区间长度要超过当前已知的最大长度
            for (int j = i + max + 1; j < s.length(); j = j + 2) {
                if (isValid(s, i, j)) {
                    max = j - i + 1;
                } else {
                    break;
                }
            }
        }

        return max;
    }

    boolean isValid(String s, int start, int end) {

        Stack<Character> stack = new Stack<>();
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    /**
     * 动态规划
     * <p>
     * 2ms, 98.82%
     */
    public int longestValidParentheses1(String s) {

        int[] dp = new int[s.length()];
        int maxLength = 0;

        for (int i = 1; i < s.length(); i++) {
            // 如果当前字符是 "(" 则长度为 0
            if (s.charAt(i) == ')') {
                // 当前字符和其前一个字符可以闭合，则当前长度为 dp[i - 2] + 2
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else {
                    // 当前字符不能和前一个闭合，但是可以和 与前一个字符闭合的字符 的前一个进行闭合
                    // pre -> '(' -> i-dp[i-1] -> i-1 -> ')' -> next
                    int indexToMatch = i - dp[i - 1] - 1;
                    if (indexToMatch >= 0 && s.charAt(indexToMatch) == '(') {
                        // 与当前字符匹配的字符的前一个字符
                        int preIndex = i - dp[i - 1] - 2;
                        dp[i] = dp[i - 1] + 2 + (preIndex >= 0 ? dp[preIndex] : 0);
                    }
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
        }

        return maxLength;
    }

    /**
     * Stack
     * <p>
     * 8ms, 41.89%
     */
    public int longestValidParentheses2(String s) {

        int maxLength = 0;

        Stack<Integer> stack = new Stack<>();

        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }

    /**
     * 计数法，常数额外空间，遍历两遍
     * <p>
     * 2ms, 98.82%
     */
    public int longestValidParentheses3(String s) {
        int left = 0, right = 0, maxLength = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLength = Math.max(maxLength, right * 2);
            } else if (left < right) {
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLength = Math.max(maxLength, right * 2);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return maxLength;
    }
}
