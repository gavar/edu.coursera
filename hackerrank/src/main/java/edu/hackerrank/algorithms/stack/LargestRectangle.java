package edu.hackerrank.algorithms.stack;

import java.util.Stack;

/**
 * Skyline Real Estate Developers is planning to demolish a number of old, unoccupied buildings and construct a shopping mall in their place.
 * Your task is to find the largest solid area in which the mall can be constructed.
 * https://www.hackerrank.com/challenges/largest-rectangle/problem
 */
public class LargestRectangle {

    static long largestRectangle(int[] h) {
        long max = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < h.length; ) {
            // advance while current is higher then previous
            if (stack.isEmpty() || h[i] >= h[stack.peek()]) {
                stack.push(i++);
            } else {
                int k = stack.pop();
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                long s = w * h[k];
                max = Math.max(max, s);
            }
        }

        int i = stack.peek() + 1;
        while (!stack.isEmpty()) {
            int k = stack.pop();
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            int s = w * h[k];
            max = Math.max(max, s);
        }

        return max;
    }
}
