package edu.codility.L05;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

public class MinAvgTwoSliceTest {
    @MethodSource("data")
    @ParameterizedTest()
    public void solve(int[] A, int expect) {
        MinAvgTwoSlice solver = new MinAvgTwoSlice();
        int actual = solver.solution(A);
        assertEquals(expect, actual);
    }

    static Arguments[] data() {
        return new Arguments[]{
                // examples
                of(new int[]{4, 2, 2, 5, 1, 5, 8}, 1),
                of(new int[]{-3, -5, -8, -4, -10}, 2),
        };
    }
}
