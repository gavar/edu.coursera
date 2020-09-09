package edu.codility.L04;

import java.util.HashSet;

public class PermCheck {
    public int solution(int[] A) {
        HashSet<Integer> numbers = new HashSet<>();

        int N = 0;
        for (int number : A) {
            if (number < 1) return 0;
            N = Math.max(N, number);
            if (!numbers.add(number)) return 0;
        }

        return numbers.size() == N ? 1 : 0;
    }
}
