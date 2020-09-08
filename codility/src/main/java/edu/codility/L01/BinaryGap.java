package edu.codility.L01;

public class BinaryGap {
    public int solution(int N) {
        int max = 0;

        // skip trailing zeros
        while (N > 0 && N % 2 == 0)
            N = N >> 1;

        for (int length = 0; N > 0; N = N >> 1)
            if (N % 2 == 0) {
                length++;
            } else {
                max = Math.max(max, length);
                length = 0;
            }

        return max;
    }
}
