package com.xinping.leetcode.solutions;

import junit.framework.TestCase;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class ZigzagConversionTest extends TestCase {

    HashMap<Map.Entry<String, Integer>, String> testCases = new HashMap<Map.Entry<String, Integer>, String>();

    public void setUp() throws Exception {
        super.setUp();
        testCases.put(new AbstractMap.SimpleEntry<String, Integer>("LEETCODEISHIRING", 3), "LCIRETOESIIGEDHN");
        testCases.put(new AbstractMap.SimpleEntry<String, Integer>("LEETCODEISHIRING", 4), "LDREOEIIECIHNTSG");
        testCases.put(new AbstractMap.SimpleEntry<String, Integer>("A", 1), "A");
    }

    public void testConvert() {
        ZigzagConversion zigzagConversion = new ZigzagConversion();
        for (Map.Entry<Map.Entry<String, Integer>, String> entry : testCases.entrySet()) {
            assertEquals(entry.getValue(), zigzagConversion.convert(entry.getKey().getKey(), entry.getKey().getValue()));
        }
    }

    public void testConvert1() {
        ZigzagConversion zigzagConversion = new ZigzagConversion();
        for (Map.Entry<Map.Entry<String, Integer>, String> entry : testCases.entrySet()) {
            assertEquals(entry.getValue(), zigzagConversion.convert1(entry.getKey().getKey(), entry.getKey().getValue()));
        }
    }
}