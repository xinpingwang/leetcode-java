package com.xinping.leetcode.solutions;

public class ZigzagConversion {

    /**
     * 每一行竖线上的字符依次为 i + j * roundLen， 斜线上的字符为 i + (j + 1) * roundLen - 2 * i
     * <p>
     * 5ms, 85.15%
     */
    public String convert(String s, int numRows) {
        // 如果 numRows < 2，则下面的 roundLen 公式不成立
        if (numRows == 1) {
            return s;
        }

        int roundLen = numRows * 2 - 2;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; i + j * roundLen < s.length(); j++) {
                sb.append(s.charAt(i + j * roundLen));
                int zigIndex = i + (j + 1) * roundLen - 2 * i;
                if (i > 0 && i < numRows - 1 && zigIndex < s.length()) {
                    sb.append(s.charAt(zigIndex));
                }
            }
        }

        return sb.toString();
    }

    /**
     * 模拟真实的 Zigzag 操作，依次将字符串中的字符放入对应的行
     * <p>
     * 6ms, 80.48%
     */
    public String convert1(String s, int numRows) {
        // 如果 numRows == 1，则下面的循环不成立
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

        int arrow = 1, row = 0;
        for (int i = 0; i < s.length(); i++) {
            sbs[row].append(s.charAt(i));
            if ((row == 0 && arrow == -1) || (row == numRows - 1 && arrow == 1)) {
                arrow *= -1;
            }
            row += arrow;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : sbs) {
            result.append(sb);
        }

        return result.toString();
    }
}
