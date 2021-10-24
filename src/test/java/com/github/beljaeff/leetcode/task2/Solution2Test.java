package com.github.beljaeff.leetcode.task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("#2 Add Two Numbers tests (solution2 - recursive)")
class Solution2Test extends SolutionTest {

    @Override
    Solution getSolution() {
        return new Solution2();
    }

    @Test
    void test1() {
        performTest(
                generateListNode(2,4,3),
                generateListNode(5,6,4),
                generateListNode(7,0,8)
        );
    }

    @Test
    void test2() {
        performTest(
                generateListNode(0),
                generateListNode(0),
                generateListNode(0)
        );
    }

    @Test
    void test3() {
        performTest(
                generateListNode(9,9,9,9,9,9,9),
                generateListNode(9,9,9,9),
                generateListNode(8,9,9,9,0,0,0,1)
        );
    }
}
