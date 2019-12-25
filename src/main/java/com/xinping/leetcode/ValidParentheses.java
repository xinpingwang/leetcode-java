package com.xinping.leetcode;


import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

    /**
     * 利用栈来解决
     * <p>
     * 3ms, 62.20%
     */
    public boolean isValid(String s) {
        // 将闭括号作为 key，那么如果 containsKey 为 false 则表示是开括号，
        // 并且，通过 value 可以与栈中最上面的元素对比。
        HashMap<Character, Character> mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put(']', '[');
        mappings.put('}', '{');

        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (mappings.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.peek();
                if (topElement == mappings.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }
}
