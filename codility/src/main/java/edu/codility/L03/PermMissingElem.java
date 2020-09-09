package edu.codility.L03;

public class PermMissingElem {
    public int solution(int[] A) {
        long sum = 0;
        for (int v : A) sum += v;
        long N = A.length;
        long total = (N + 1L) * (N + 2L) / 2L;
        return (int)(total - sum);
    }
}
