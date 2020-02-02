package com.xinping.leetcode.solutions;

public class MultiplyStrings {

    /**
     * 竖式，注意字符串中每个字符转数字的方式
     * <p>
     * 5ms, 83.11%
     */
    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] result = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int c = a * b + result[i + j + 1];
                result[i + j + 1] = c % 10;
                result[i + j] += c / 10;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int num : result) {
            if (res.length() != 0 || num != 0) {
                res.append(num);
            }
        }

        return res.toString();
    }
}
