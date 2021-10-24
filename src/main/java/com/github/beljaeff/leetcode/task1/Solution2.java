package com.github.beljaeff.leetcode.task1;

class Solution2 implements Solution {

    /**
     * Two Sum problem solution using nested loop.
     * Complexity - O(n*n/2), where n - nums.length.
     * @param nums source array
     * @param target target sum
     * @return null when no suiting numbers found or
     *         array: (arr[0] + arr[1]) == target
     */
    @Override
    public int[] twoSum(int[] nums, int target) {
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
