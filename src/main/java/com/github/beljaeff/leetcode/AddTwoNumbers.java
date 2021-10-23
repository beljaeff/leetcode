package com.github.beljaeff.leetcode;

/**
 * See <a href="https://leetcode.com/problems/add-two-numbers/">Add Two Numbers problem</a>.
 */
class AddTwoNumbers {

    /**
     * Iterative solution for Add Two Numbers problem.
     * Complexity O(n), where n == longestLength(l1, l2)
     *
     * @param l1 first list (first number representation)
     * @param l2 second list (second number representation)
     * @return resulting number (list of digits in reverse order)
     */
    ListNode addTwoNumbers_iterative(ListNode l1, ListNode l2) {
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

    /**
     * Recursive solution for Add Two Numbers problem.
     * Complexity O(n), where n == longestLength(l1, l2)
     *
     * @param l1 first list (first number representation)
     * @param l2 second list (second number representation)
     * @return resulting number (list of digits in reverse order)
     */
    ListNode addTwoNumbers_recursive(ListNode l1, ListNode l2) {
        return addTwoNumbers_recursive(l1, l2, 0);
    }

    /**
     * Summarizes current digits from l1 and l2 lists, stores result
     * and perform call for next summarizing operation.
     *
     * @param l1Digit points to the current digit in the first number
     * @param l2Digit points to the current digit in the second number
     * @param remainder from previous operation
     * @return summarizing result or null if lists are over
     */
    private ListNode addTwoNumbers_recursive(ListNode l1Digit, ListNode l2Digit, int remainder) {
        if (l1Digit == null && l2Digit == null) {
            return remainder > 0 ? new ListNode(remainder) : null;
        }

        int value = remainder;
        if (l1Digit != null) {
            value += l1Digit.val;
            l1Digit = l1Digit.next;
        }
        if (l2Digit != null) {
            value += l2Digit.val;
            l2Digit = l2Digit.next;
        }

        return new ListNode(
                value % 10,
                addTwoNumbers_recursive(l1Digit, l2Digit, value / 10)
        );
    }
}

/**
 * Singly-linked list
 */
class ListNode {

    int val;
    ListNode next;

    ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
