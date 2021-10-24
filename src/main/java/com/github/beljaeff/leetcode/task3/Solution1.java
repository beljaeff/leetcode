package com.github.beljaeff.leetcode.task3;

import java.util.HashMap;
import java.util.Map;

class Solution1 implements Solution {

    /**
     * Find length of longest substring without repeating characters
     * using hash map. Complexity - O(n), where n - s.length().
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
        Map<Character, Integer> charIndexes = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            Integer foundIndex = charIndexes.get(c);
            if (foundIndex != null && foundIndex >= beginIndex) {
                int currentSequence = i - beginIndex;
                if (currentSequence > longestSequence) {
                    longestSequence = currentSequence;
                }
                beginIndex = foundIndex + 1;
            }
            charIndexes.put(c, i);
        }

        int currentSequence = s.length() - beginIndex;
        if (currentSequence > longestSequence) {
            longestSequence = currentSequence;
        }

        return longestSequence;
    }
}
