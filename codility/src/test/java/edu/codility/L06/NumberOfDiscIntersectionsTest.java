package edu.codility.L06;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

public class NumberOfDiscIntersectionsTest {
    @MethodSource("data")
    @ParameterizedTest()
    public void solve(int[] A, int expect) {
        NumberOfDiscIntersections solver = new NumberOfDiscIntersections();
        int actual = solver.solution(A);
        assertEquals(expect, actual);
    }

    static Arguments[] data() {
        return new Arguments[]{
                // examples
                of(new int[]{1, 5, 2, 1, 4, 0}, 11),
                // extreme small
                of(new int[]{}, 0),
                of(new int[]{10}, 0),
                // simple 3
                of(new int[]{1, 0, 1, 0, 1}, 6),
                // overflow
                of(new int[]{1, 2147483647, 0}, 2),
        };
    }
}
