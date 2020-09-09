package edu.codility.L04;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

public class MissingIntegerTest {
    @MethodSource("data")
    @ParameterizedTest()
    public void solve(int[] A, int expect) {
        MissingInteger solver = new MissingInteger();
        int actual = solver.solution(A);
        assertEquals(expect, actual);
    }

    static Arguments[] data() {
        return new Arguments[]{
                // examples
                of(new int[]{1, 3, 6, 4, 1, 2}, 5),
                of(new int[]{1, 2, 3}, 4),
                of(new int[]{-1, -3}, 1),
        };
    }
}
