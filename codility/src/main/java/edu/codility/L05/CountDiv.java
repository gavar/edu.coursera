package edu.codility.L05;

public class CountDiv {
    public int solution(int A, int B, int K) {
        int count = B / K - A / K;
        if (A % K == 0) count++;
        return count;
    }
}
