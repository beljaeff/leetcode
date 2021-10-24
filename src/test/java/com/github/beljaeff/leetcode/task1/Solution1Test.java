package com.github.beljaeff.leetcode.task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("#1 Two Sum tests (solution1 - hash map)")
class Solution1Test extends SolutionTest {

    @Override
    Solution getSolution() {
        return new Solution1();
    }

    @Test
    void test1() {
        performTest(new int[] { 0, 1 }, new int[] { 2, 7, 11, 15 }, 9);
    }

    @Test
    void test2() {
        performTest(new int[] { 1, 2 }, new int[] { 3, 2, 4 }, 6);
    }

    @Test
    void test3() {
        performTest(new int[] { 0, 1 }, new int[] { 3, 3 }, 6);
    }
}
