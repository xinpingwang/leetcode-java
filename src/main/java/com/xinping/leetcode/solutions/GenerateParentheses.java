package com.xinping.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

    /**
     * 暴力
     * <p>
     * 28ms, 5.21%
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack("", n * 2, result);
        return result;
    }

    void backtrack(String p, int n, List<String> result) {
        if (p.length() == n) {
            if (validParenthesis(p)) {
                result.add(p);
            }
            return;
        }

        backtrack(p + "(", n, result);
        backtrack(p + ")", n, result);
    }

    boolean validParenthesis(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.empty() || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.empty();
    }


    /**
     * 回溯法
     * <p>
     * 1ms, 99.54%
     */
    public List<String> generateParenthesis1(int n) {
        List<String> result = new ArrayList<>();
        backtrack1("", 0, 0, n, result);
        return result;
    }

    void backtrack1(String current, int open, int close, int max, List<String> result) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max) {
            backtrack1(current + "(", open + 1, close, max, result);
        }
        // 保证闭括号的数量不大于开括号的数量，从而生成的永远满足条件
        if (close < open) {
            backtrack1(current + ")", open, close + 1, max, result);
        }
    }

    /**
     * 递归, 将问题转化为: (left)right
     * <p>
     * 5ms, 13.37%
     */
    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            result.add("");
        } else {
            for (int i = 0; i < n; i++) {
                for (String left : generateParenthesis2(i)) {
                    for (String right : generateParenthesis2(n - i - 1)) {
                        result.add("(" + left + ")" + right);
                    }
                }
            }
        }

        return result;
    }
}
