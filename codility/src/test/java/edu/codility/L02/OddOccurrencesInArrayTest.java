package edu.codility.L02;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

public class OddOccurrencesInArrayTest {
    @MethodSource("data")
    @ParameterizedTest()
    public void solve(int[] A, int expect) {
        OddOccurrencesInArray solver = new OddOccurrencesInArray();
        int actual = solver.solution(A);
        assertEquals(expect, actual);
    }

    static Arguments[] data() {
        return new Arguments[]{
                // examples
                of(new int[]{9, 3, 9, 3, 9, 7, 9}, 1)
        };
    }
}
