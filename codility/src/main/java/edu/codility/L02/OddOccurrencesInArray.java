package edu.codility.L02;

public class OddOccurrencesInArray {
    public int solution(int[] A) {
        int odd = 0;
        for (int v : A) odd ^= v;
        return odd;
    }
}
