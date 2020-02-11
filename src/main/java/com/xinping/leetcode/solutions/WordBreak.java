package com.xinping.leetcode.solutions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    /**
     * 暴力
     * <p>
     * 超时
     */
    public boolean wordBreak(String s, List<String> wordDict) {

        if (s.length() == 0) {
            return true;
        }

        for (String word : wordDict) {
            if (s.startsWith(word) && wordBreak(s.substring(word.length()), wordDict)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 动态规划+哈希
     * <p>
     * 10ms, 17.24%
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        HashSet<String> wordDictSet = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
