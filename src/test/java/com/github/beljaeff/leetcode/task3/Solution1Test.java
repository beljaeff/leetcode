package com.github.beljaeff.leetcode.task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("#3 Longest Substring Without Repeating Characters tests (solution1 - hash map)")
class Solution1Test extends SolutionTest {

    @Override
    Solution getSolution() {
        return new Solution1();
    }

    @Test
    void test1() {
        performTest("abcabcbb", 3);
    }

    @Test
    void test2() {
        performTest("bbbbb", 1);
    }

    @Test
    void test3() {
        performTest("pwwkew", 3);
    }

    @Test
    void test4() {
        performTest("", 0);
    }

    @Test
    void test5() {
        performTest(" ", 1);
    }

    @Test
    void test6() {
        performTest("au", 2);
    }

    @Test
    void test7() {
        performTest("aab", 2);
    }

    @Test
    void test8() {
        performTest("abba", 2);
    }
}
