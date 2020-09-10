package edu.codility.L05;

public class MinAvgTwoSlice {
    public int solution(int[] A) {
        int slice = 0;
        int sum = A[0] + A[1];
        double avg = sum / 2.0;
        double min = avg;

        int i = 0;
        int j = 2;
        while (j < A.length) {
            // expand to right if too few numbers or next is less than average
            if (j - i == 1 || A[j] <= avg) sum += A[j++];
            else sum -= A[i++];

            // check if new average less than minimal
            int size = j - i;
            avg = (double) sum / size;
            if (size >= 2 && avg < min) {
                min = avg;
                slice = i;
            }

        }

        // shrink tail to 2 elements
        // to check if that may produce better results
        while (j - i > 2) {
            sum -= A[i++];
            int size = j - i;
            avg = (double) sum / size;
            if (avg < min) {
                min = avg;
                slice = i;
            }
        }

        return slice;
    }
}
