package com.github.beljaeff.leetcode.task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("#1 Two Sum tests (solution2 - nested loops)")
class Solution2Test extends SolutionTest {

    @Override
    Solution getSolution() {
        return new Solution2();
    }

    @Test
    void twoSum_nestedLoops_test1() {
        performTest(new int[] { 0, 1 }, new int[] {2, 7, 11, 15 }, 9);
    }

    @Test
    void twoSum_nestedLoops_test2() {
        performTest(new int[] { 1, 2 }, new int[] { 3, 2, 4 }, 6);
    }

    @Test
    void twoSum_nestedLoops_test3() {
        performTest(new int[] { 0, 1 }, new int[] { 3, 3 }, 6);
    }
}
