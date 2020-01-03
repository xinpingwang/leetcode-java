package com.xinping.leetcode.solutions;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRomanTest extends TestCase {

    HashMap<Integer, String> testCases = new HashMap<Integer, String>();

    public void setUp() throws Exception {
        super.setUp();
        testCases.put(3, "III");
        testCases.put(4, "IV");
        testCases.put(9, "IX");
        testCases.put(58, "LVIII");
        testCases.put(1994, "MCMXCIV");
    }

    public void testIntToRoman() {
        IntegerToRoman toRoman = new IntegerToRoman();

        for (Map.Entry<Integer, String> entry : testCases.entrySet()) {
            assertEquals(entry.getValue(), toRoman.intToRoman(entry.getKey()));
        }
    }
}