package edu.codility.L02;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

public class CyclicRotationTest {
    @MethodSource("data")
    @ParameterizedTest()
    public void solve(int[] A, int K, int[] expect) {
        CyclicRotation solver = new CyclicRotation();
        int[] actual = solver.solution(A, K);
        assertArrayEquals(expect, actual);
    }

    static Arguments[] data() {
        return new Arguments[]{
                // examples
                of(new int[]{3, 8, 9, 7, 6}, 3, new int[]{9, 7, 6, 3, 8}),
                of(new int[]{0, 0, 0}, 1, new int[]{0, 0, 0}),
                of(new int[]{1, 2, 3, 4}, 4, new int[]{1, 2, 3, 4}),
                // empty
                of(new int[]{}, 4, new int[]{}),
        };
    }
}
