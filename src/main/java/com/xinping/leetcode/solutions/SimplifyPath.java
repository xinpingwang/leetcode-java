package com.xinping.leetcode.solutions;

import java.util.Stack;

public class SimplifyPath {

    /**
     * 栈，注意边界处理
     * <p>
     * 6ms, 83.13%
     */
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (String s : split) {
            if (s.length() > 0 && !s.equals(".")) {
                if (s.equals("..")) {
                    if (!stack.empty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(s);
                }
            }
        }

        if (stack.empty()) {
            return "/";
        }

        while (!stack.empty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }

        return sb.toString();
    }
}
