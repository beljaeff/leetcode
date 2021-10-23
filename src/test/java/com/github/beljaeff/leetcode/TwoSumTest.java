package com.github.beljaeff.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

class TwoSumTest {

    private final TwoSum app = new TwoSum();

    @Test
    void twoSum_hashMap_test1() {
        performTest(
                new int[] { 0, 1 }, new int[] { 2, 7, 11, 15 }, 9,
                "twoSum_hashMap", app::twoSum_hashMap
        );
    }

    @Test
    void twoSum_hashMap_test2() {
        performTest(
                new int[] { 1, 2 }, new int[] { 3, 2, 4 }, 6,
                "twoSum_hashMap", app::twoSum_hashMap
        );
    }

    @Test
    void twoSum_hashMap_test3() {
        performTest(
                new int[] { 0, 1 }, new int[] { 3, 3 }, 6,
                "twoSum_hashMap", app::twoSum_hashMap
        );
    }

    @Test
    void twoSum_nestedLoops_test1() {
        performTest(
                new int[] { 0, 1 }, new int[] {2, 7, 11, 15 }, 9,
                "twoSum_nestedLoops", app::twoSum_nestedLoops
        );
    }

    @Test
    void twoSum_nestedLoops_test2() {
        performTest(
                new int[] { 1, 2 }, new int[] { 3, 2, 4 }, 6,
                "twoSum_nestedLoops", app::twoSum_nestedLoops
        );
    }

    @Test
    void twoSum_nestedLoops_test3() {
        performTest(
                new int[] { 0, 1 }, new int[] { 3, 3 }, 6,
                "twoSum_nestedLoops", app::twoSum_nestedLoops
        );
    }

    private void performTest(int[] expected, int[] nums, int target,
                             String methodName, BiFunction<int[], Integer, int[]> method) {
        System.out.println(methodName + "(" + toList(nums) + ", " + target + ")");
        System.out.println("Expected: " + toList(expected));

        int[] actual = method.apply(nums, target);
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
