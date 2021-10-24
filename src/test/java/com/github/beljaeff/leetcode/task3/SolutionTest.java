package com.github.beljaeff.leetcode.task3;

import org.junit.jupiter.api.Assertions;

abstract class SolutionTest {

    private final Solution solution = getSolution();

    abstract Solution getSolution();

    void performTest(String string, int expected) {
        System.out.println("lengthOfLongestSubstring(" + string + ")");
        System.out.println("Expected: " + expected);

        int actual = solution.lengthOfLongestSubstring(string);
        System.out.println("Actual:   " + actual + "\n");

        Assertions.assertEquals(expected, actual);
    }
}
