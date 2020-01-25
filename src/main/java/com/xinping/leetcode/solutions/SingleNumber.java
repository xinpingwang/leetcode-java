package com.xinping.leetcode.solutions;

import java.util.HashSet;

public class SingleNumber {

    /**
     * 暴力
     * <p>
     * 79ms, 8.27%
     */
    public int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean found = false;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && i != j) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 哈希
     * <p>
     * 12ms, 22.99%
     */
    public int singleNumber1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            } else {
                set.remove(num);
            }
        }

        return set.isEmpty() ? -1 : (int) set.toArray()[0];
    }

    /**
     * 位运算：a⊕0=a; a⊕a=0; a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
     * <p>
     * 1ms, 99.52%
     */
    public int singleNumber2(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
