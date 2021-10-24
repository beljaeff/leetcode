package com.github.beljaeff.leetcode.task2;

import org.junit.jupiter.api.Assertions;

abstract class SolutionTest {

    private final Solution solution = getSolution();

    abstract Solution getSolution();

    void performTest(ListNode first, ListNode second, ListNode expected) {
        System.out.println("addTwoNumbers(" + listToString(first) + ", " + listToString(second) + ")");
        System.out.println("Expected: " + listToString(expected));

        ListNode actual = solution.addTwoNumbers(first, second);
        System.out.println("Actual:   " + listToString(actual) + "\n");

        checkResult(actual, expected);
    }

    private void checkResult(ListNode actual, ListNode expected) {
        while (!(actual == null && expected == null)) {
            assert actual != null;
            Assertions.assertEquals(actual.val, expected.val);
            actual = actual.next;
            expected = expected.next;
        }
    }

    private String listToString(ListNode node) {
        StringBuilder builder = new StringBuilder();
        for (; node != null; node = node.next) {
            builder.append(node.val);
        }
        return builder.toString();
    }

    ListNode generateListNode(int ... values) {
        ListNode result = null, previousNode = null;
        for (int value : values) {
            ListNode node = new ListNode(value);
            if (result == null) {
                result = node;
                previousNode = node;
                continue;
            }
            previousNode.next = node;
            previousNode = node;
        }
        return result;
    }
}
