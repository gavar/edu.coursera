package edu.codility.L04;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {
    public int solution(int[] A) {
        Set<Integer> numbers = new HashSet<>();

        for (int n : A)
            if (n > 0)
                numbers.add(n);

        int min = 1;
        while (numbers.contains(min))
            min++;

        return min;
    }
}
