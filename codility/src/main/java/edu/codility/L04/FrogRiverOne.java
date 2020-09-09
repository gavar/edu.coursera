package edu.codility.L04;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {
    public int solution(int X, int[] A) {
        Set<Integer> positions = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            int position = A[i];

            if (position > 0 && position <= X)
                positions.add(position);

            if (positions.size() == X)
                return i;
        }
        return -1;
    }
}
