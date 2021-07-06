package com.github.beljaeff.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

class LongestSubstringWithoutRepeatingCharactersTest {

    private LongestSubstringWithoutRepeatingCharacters app = new LongestSubstringWithoutRepeatingCharacters();

    @Test
    void lengthOfLongestSubstring_hashMap_test1() {
        performTest(
                "abcabcbb", 3,
                "lengthOfLongestSubstring_hashMap", app::lengthOfLongestSubstring_hashMap
        );
    }

    @Test
    void lengthOfLongestSubstring_hashMap_test2() {
        performTest(
                "bbbbb", 1,
                "lengthOfLongestSubstring_hashMap", app::lengthOfLongestSubstring_hashMap
        );
    }

    @Test
    void lengthOfLongestSubstring_hashMap_test3() {
        performTest(
                "pwwkew", 3,
                "lengthOfLongestSubstring_hashMap", app::lengthOfLongestSubstring_hashMap
        );
    }

    @Test
    void lengthOfLongestSubstring_hashMap_test4() {
        performTest(
                "", 0,
                "lengthOfLongestSubstring_hashMap", app::lengthOfLongestSubstring_hashMap
        );
    }

    @Test
    void lengthOfLongestSubstring_hashMap_test5() {
        performTest(
                " ", 1,
                "lengthOfLongestSubstring_hashMap", app::lengthOfLongestSubstring_hashMap
        );
    }

    @Test
    void lengthOfLongestSubstring_hashMap_test6() {
        performTest(
                "au", 2,
                "lengthOfLongestSubstring_hashMap", app::lengthOfLongestSubstring_hashMap
        );
    }

    @Test
    void lengthOfLongestSubstring_hashMap_test7() {
        performTest(
                "aab", 2,
                "lengthOfLongestSubstring_hashMap", app::lengthOfLongestSubstring_hashMap
        );
    }

    @Test
    void lengthOfLongestSubstring_hashMap_test8() {
        performTest(
                "abba", 2,
                "lengthOfLongestSubstring_hashMap", app::lengthOfLongestSubstring_hashMap
        );
    }

    @Test
    void lengthOfLongestSubstring_reverseSearch_test1() {
        performTest(
                "abcabcbb", 3,
                "lengthOfLongestSubstring_reverseSearch", app::lengthOfLongestSubstring_reverseSearch
        );
    }

    @Test
    void lengthOfLongestSubstring_reverseSearch_test2() {
        performTest(
                "bbbbb", 1,
                "lengthOfLongestSubstring_reverseSearch", app::lengthOfLongestSubstring_reverseSearch
        );
    }

    @Test
    void lengthOfLongestSubstring_reverseSearch_test3() {
        performTest(
                "pwwkew", 3,
                "lengthOfLongestSubstring_reverseSearch", app::lengthOfLongestSubstring_reverseSearch
        );
    }

    @Test
    void lengthOfLongestSubstring_reverseSearch_test4() {
        performTest(
                "", 0,
                "lengthOfLongestSubstring_reverseSearch", app::lengthOfLongestSubstring_reverseSearch
        );
    }

    @Test
    void lengthOfLongestSubstring_reverseSearch_test5() {
        performTest(
                " ", 1,
                "lengthOfLongestSubstring_reverseSearch", app::lengthOfLongestSubstring_reverseSearch
        );
    }

    @Test
    void lengthOfLongestSubstring_reverseSearch_test6() {
        performTest(
                "au", 2,
                "lengthOfLongestSubstring_reverseSearch", app::lengthOfLongestSubstring_reverseSearch
        );
    }

    @Test
    void lengthOfLongestSubstring_reverseSearch_test7() {
        performTest(
                "aab", 2,
                "lengthOfLongestSubstring_reverseSearch", app::lengthOfLongestSubstring_reverseSearch
        );
    }

    @Test
    void lengthOfLongestSubstring_reverseSearch_test8() {
        performTest(
                "abba", 2,
                "lengthOfLongestSubstring_reverseSearch", app::lengthOfLongestSubstring_reverseSearch
        );
    }

    private void performTest(String string, int expected,
                             String methodName, Function<String, Integer> method) {
        System.out.println(methodName + "(" + string + ")");
        System.out.println("Expected: " + expected);

        int actual = method.apply(string);
        System.out.println("Actual:   " + actual + "\n");

        Assertions.assertEquals(expected, actual);
    }
}
