package com.xinping.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    HashMap<Character, String> valueMap = new HashMap<>();

    List<String> output = new ArrayList<String>();

    /**
     * 回溯法
     * <p>
     * 1ms, 93.75%
     */
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        valueMap.put('2', "abc");
        valueMap.put('3', "def");
        valueMap.put('4', "ghi");
        valueMap.put('5', "jkl");
        valueMap.put('6', "mno");
        valueMap.put('7', "pqrs");
        valueMap.put('8', "tuv");
        valueMap.put('9', "wxyz");

        backtrack("", digits, 0);

        return output;
    }

    void backtrack(String combination, String digits, int index) {
        if (index == digits.length()) {
            output.add(combination);
        } else {
            String letters = valueMap.get(digits.charAt(index));
            for (char letter : letters.toCharArray()) {
                backtrack(combination + letter, digits, index + 1);
            }
        }
    }
}
