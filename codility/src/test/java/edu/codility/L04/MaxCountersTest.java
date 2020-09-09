package edu.codility.L04;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

public class MaxCountersTest {
    @MethodSource("data")
    @ParameterizedTest()
    public void solve(int N, int[] A, int[] expect) {
        MaxCounters solver = new MaxCounters();
        int[] actual = solver.solution(N, A);
        assertArrayEquals(expect, actual);
    }

    static Arguments[] data() {
        return new Arguments[]{
                // examples
                of(5, new int[]{3, 4, 4, 6, 1, 4, 4}, new int[]{3, 2, 2, 4, 2})
        };
    }
}
