package edu.codility.L02;

public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        if (A.length > 0)
            for (K = K % A.length; K > 0; K--) {
                int last = A[A.length - 1];
                System.arraycopy(A, 0, A, 1, A.length - 1);
                A[0] = last;
            }
        return A;
    }
}
