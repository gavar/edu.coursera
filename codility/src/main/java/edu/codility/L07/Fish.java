package edu.codility.L07;

import java.util.Stack;

public class Fish {
    public int solution(int[] A, int[] B) {
        int N = A.length;
        int alive = N;

        Stack<Integer> fish = new Stack<>();
        for (int i = 0; i < N; i++) {
            // collect downstream fish
            if (B[i] == 1) {
                fish.push(A[i]);
            } else {
                // downstream eats downstream
                while (!fish.empty() && fish.peek() < A[i]) {
                    fish.pop();
                    alive--;
                }

                // upstream eats downstream
                if (!fish.empty() && fish.peek() > A[i]) {
                    alive--;
                }
            }
        }

        return alive;
    }
}
