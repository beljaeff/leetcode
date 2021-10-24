package com.github.beljaeff.leetcode.task3;

class Solution2 implements Solution {

     /**
     * Find length of longest substring without repeating characters
     * searching back to find repeating characters.
     * Complexity - O(n*n/2), where n - s.length().
     * @param s given string
     * @return length of longest substring without repeating characters
     */
    @Override
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int beginIndex = 0;
        int longestSequence = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            int currentSequence = 1;
            for (int j=i-1; j>=beginIndex; j--) {
                char cc = s.charAt(j);
                if (c == cc) {
                    beginIndex = j+1;
                    break;
                }
                currentSequence++;
            }
            if (currentSequence > longestSequence) {
                longestSequence = currentSequence;
            }
        }
        return longestSequence;
    }
}
