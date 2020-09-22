package edu.codility.L06;

import java.util.Arrays;

public class MaxProductOfThree {
    public int solution(int[] A) {
        Arrays.sort(A);
        int N = A.length;
        int L = product(A, 0, 1, N - 1);
        int R = product(A, N - 3, N - 2, N - 1);
        return Math.max(L, R);
    }

    private int product(int[] A, int P, int Q, int R) {
        return A[P] * A[Q] * A[R];
    }
}
