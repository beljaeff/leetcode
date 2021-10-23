package com.github.beljaeff.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * See <a href="https://leetcode.com/problems/two-sum/">Two Sum problem</a>.
 */
class TwoSum {

    /**
     * Two Sum problem solution using hash map.
     * Complexity - O(n), where n - nums.length.
     * @param nums source array
     * @param target target sum
     * @return null when no suiting numbers found or
     *         array: (arr[0] + arr[1]) == target
     */
    int[] twoSum_hashMap(int[] nums, int target) {
        Map<Integer, Integer> storage = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            Integer found = storage.get(target - nums[i]);
            if (found != null) {
                int[] result = new int[2];
                result[0] = found;
                result[1] = i;
                return result;
            }
            storage.put(nums[i], i);
        }
        return null;
    }

    /**
     * Two Sum problem solution using nested loop.
     * Complexity - O(n*n/2), where n - nums.length.
     * @param nums source array
     * @param target target sum
     * @return null when no suiting numbers found or
     *         array: (arr[0] + arr[1]) == target
     */
    int[] twoSum_nestedLoops(int[] nums, int target) {
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] result = new int[2];
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }
}
