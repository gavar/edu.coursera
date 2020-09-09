package edu.codility.L03;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

public class TapeEquilibriumTest {
    @MethodSource("data")
    @ParameterizedTest()
    public void solve(int[] A, int expect) {
        TapeEquilibrium solver = new TapeEquilibrium();
        int actual = solver.solution(A);
        assertEquals(expect, actual);
    }

    static Arguments[] data() {
        return new Arguments[]{
                // examples
                of(new int[]{3, 1, 2, 4, 3}, 1),
                // custom
                of(new int[]{-5, -4, -6, -9}, 6),
                of(new int[]{-5, -4, -6, -4}, 1),
                of(new int[]{-5, -4, -6, -15}, 0),
                of(new int[]{5, 4, -4, -5}, 10),
        };
    }
}
