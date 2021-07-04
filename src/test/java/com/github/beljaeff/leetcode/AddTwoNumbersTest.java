package com.github.beljaeff.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

class AddTwoNumbersTest {

    private AddTwoNumbers app = new AddTwoNumbers();

    @Test
    void iterativeTest1() {
        performTest(
                generateListNode(2,4,3),
                generateListNode(5,6,4),
                generateListNode(7,0,8),
                "addTwoNumbers_iterative",
                app::addTwoNumbers_iterative
        );
    }

    @Test
    void iterativeTest2() {
        performTest(
                generateListNode(0),
                generateListNode(0),
                generateListNode(0),
                "addTwoNumbers_iterative",
                app::addTwoNumbers_iterative
        );
    }

    @Test
    void iterativeTest3() {
        performTest(
                generateListNode(9,9,9,9,9,9,9),
                generateListNode(9,9,9,9),
                generateListNode(8,9,9,9,0,0,0,1),
                "addTwoNumbers_iterative",
                app::addTwoNumbers_iterative
        );
    }

    @Test
    void recursiveTest1() {
        performTest(
                generateListNode(2,4,3),
                generateListNode(5,6,4),
                generateListNode(7,0,8),
                "addTwoNumbers_recursive",
                app::addTwoNumbers_recursive
        );
    }

    @Test
    void recursiveTest2() {
        performTest(
                generateListNode(0),
                generateListNode(0),
                generateListNode(0),
                "addTwoNumbers_recursive",
                app::addTwoNumbers_recursive
        );
    }

    @Test
    void recursiveTest3() {
        performTest(
                generateListNode(9,9,9,9,9,9,9),
                generateListNode(9,9,9,9),
                generateListNode(8,9,9,9,0,0,0,1),
                "addTwoNumbers_recursive",
                app::addTwoNumbers_recursive
        );
    }

    private void performTest(ListNode first, ListNode second, ListNode expected,
                             String methodName, BiFunction<ListNode, ListNode, ListNode> method) {
        System.out.println(methodName + "(" + listToString(first) + ", " + listToString(second) + ")");
        System.out.println("Expected: " + listToString(expected));

        ListNode actual = method.apply(first, second);
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

    private ListNode generateListNode(int ... values) {
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
