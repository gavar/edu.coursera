package edu.codility.L04;

public class MaxCounters {
    public int[] solution(int N, int[] A) {
        int min = 0;
        int max = 0;
        int[] counters = new int[N];

        for (int x : A) {
            if (x <= N) {
                int c = Math.max(min, counters[x - 1]) + 1;
                max = Math.max(max, c);
                counters[x - 1] = c;
            } else {
                min = max;
            }
        }

        for (int i = 0; i < N; i++)
            counters[i] = Math.max(min, counters[i]);

        return counters;
    }
}
