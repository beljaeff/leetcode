package com.github.beljaeff.leetcode.task2;

class Solution1 implements Solution {

    /**
     * Iterative solution for Add Two Numbers problem.
     * Complexity O(n), where n == longestLength(l1, l2)
     *
     * @param l1 first list (first number representation)
     * @param l2 second list (second number representation)
     * @return resulting number (list of digits in reverse order)
     */
    @Override
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null, lastNode = null;
        int value = 0;
        while (!(l1 == null && l2 == null)) {
            if (l1 != null) {
                value += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }

            ListNode node = new ListNode(value % 10);
            value /= 10;

            if (result == null) {
                result = node;
                lastNode = node;
                continue;
            }

            lastNode.next = node;
            lastNode = node;
        }

        if (value > 0) {
            lastNode.next = new ListNode(value);
        }
        return result;
    }
}
