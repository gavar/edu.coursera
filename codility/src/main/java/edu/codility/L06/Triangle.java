package edu.codility.L06;

import java.util.Arrays;

public class Triangle {
    public int solution(int[] A) {
        int N = A.length;
        Arrays.sort(A);

        for (int P = 0, Q = 1, R = 2; P < Q && Q < R && R < N; ) {
            if (le(A[P], A[Q], A[R])) P++;
            else if (le(A[Q], A[R], A[P])) Q++;
            else if (le(A[R], A[P], A[Q])) R++;
            else return 1;

            if (P >= Q) Q++;
            if (Q >= R) R++;
        }

        return 0;
    }

    static boolean le(long a, long b, long c) {
        return a + b <= c;
    }
}
