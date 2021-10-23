package com.github.beljaeff.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * See
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">
 *     Longest Substring Without Repeating Characters</a>.
 */
class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Find length of longest substring without repeating characters
     * using hash map. Complexity - O(n), where n - s.length().
     * @param s given string
     * @return length of longest substring without repeating characters
     */
    int lengthOfLongestSubstring_hashMap(String s) {
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

    /**
     * Find length of longest substring without repeating characters
     * searching back to find repeating characters.
     * Complexity - O(n*n/2), where n - s.length().
     * @param s given string
     * @return length of longest substring without repeating characters
     */
    int lengthOfLongestSubstring_reverseSearch(String s) {
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
