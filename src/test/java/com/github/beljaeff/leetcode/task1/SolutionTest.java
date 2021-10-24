package com.github.beljaeff.leetcode.task1;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

abstract class SolutionTest {

    private final Solution solution = getSolution();

    abstract Solution getSolution();

    void performTest(int[] expected, int[] nums, int target) {
        System.out.println("twoSum(" + toList(nums) + ", " + target + ")");
        System.out.println("Expected: " + toList(expected));

        int[] actual = solution.twoSum(nums, target);
        System.out.println("Actual:   " + toList(actual) + "\n");

        Assertions.assertEquals(expected.length, actual.length);

        for (int i=0; i<actual.length; i++) {
            Assertions.assertEquals(expected[i], actual[i]);
        }
    }

    private List<Integer> toList(int[] array) {
        return Arrays.stream(array).boxed().collect(Collectors.toList());
    }
}
