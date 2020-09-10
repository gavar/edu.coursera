package edu.codility.L05;

public class PassingCars {
    public int solution(int[] A) {
        int MAX = 1000000000 * 2;
        long cars = 0;

        // moving to the right
        for (int i = 0, count = 0; i < A.length; i++){
            if (A[i] == 0) count++;
            else cars += count;
            if (cars > MAX) return -1;
        }

        // moving to the left
        for (int i = A.length - 1, count = 0; i >= 0; i--) {
            if (A[i] == 1) count++;
            else cars += count;
            if (cars > MAX) return -1;
        }

        return (int)(cars / 2);
    }
}
