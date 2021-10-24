package com.github.beljaeff.leetcode.task1;

import java.util.HashMap;
import java.util.Map;

class Solution1 implements Solution {

    /**
     * Two Sum problem solution using hash map.
     * Complexity - O(n), where n - nums.length.
     * @param nums source array
     * @param target target sum
     * @return null when no suiting numbers found or
     *         array: (arr[0] + arr[1]) == target
     */
    @Override
    public int[] twoSum(int[] nums, int target) {
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
}
