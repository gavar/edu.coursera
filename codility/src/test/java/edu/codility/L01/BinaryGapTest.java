package edu.codility.L01;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

public class BinaryGapTest {
    @MethodSource("data")
    @ParameterizedTest(name = "N = {0}")
    public void solve(int N, int expect) {
        BinaryGap solver = new BinaryGap();
        int actual = solver.solution(N);
        assertEquals(expect, actual);
    }

    static Arguments[] data() {
        return new Arguments[]{
                // examples
                of(1041, 5),
                of(15, 0),
                of(32, 0),
                // extremes
                of(1, 0),
                of(5, 1),
                of(2147483647, 0),
                // trailing_zeroes
                of(6, 0),
                of(328, 2),
                // power of 2
                of(16, 0),
                of(1024, 0),
                // simple
                of(9, 2),
                of(11, 1),
                of(19, 2),
                of(42, 1),
                of(1162, 3),
                // medium
                of(561892, 3),
                of(66561, 9),
                // large
                of(6291457, 20),
                of(74901729, 4),
                of(805306373, 25),
                of(1376796946, 5),
                of(1073741825, 29),
                of(1610612737, 28),
        };
    }
}
