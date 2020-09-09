package edu.codility.L03;

public class TapeEquilibrium {
    public int solution(int[] A) {
        long right = 0;
        for (int v : A) right += v;

        long left = 0;
        long min = Integer.MAX_VALUE;
        for (int i = 0, s = A.length - 1; i < s; i++) {
            left += A[i];
            right -= A[i];
            min = Math.min(min, Math.abs(left - right));
        }

        return (int) min;
    }
}
