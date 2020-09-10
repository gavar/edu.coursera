package edu.codility.L05;

public class GenomicRangeQuery {
    public int[] solution(String S, int[] P, int[] Q) {
        int length = S.length();
        int[][] memory = new int[length + 1][4];
        memory[0] = new int[4];

        for (int i = 1; i <= length; i++) {
            int w = weightOf(S.charAt(i - 1));
            memory[i] = memory[i - 1].clone();
            memory[i][w - 1]++;
        }

        int N = P.length;
        int[] ans = new int[N];

        for (int K = 0; K < N; K++) {
            int[] a = memory[P[K]];
            int[] b = memory[Q[K] + 1];
            for (int i = 0; i < 4; i++) {
                if (b[i] - a[i] > 0) {
                    ans[K] = i + 1;
                    break;
                }
            }
        }

        return ans;
    }

    int weightOf(char c) {
        switch (c) {
            case 'A':
                return 1;
            case 'C':
                return 2;
            case 'G':
                return 3;
            case 'T':
                return 4;
            default:
                return 0;
        }
    }
}
