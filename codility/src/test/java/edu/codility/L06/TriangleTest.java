package edu.codility.L06;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {
    @MethodSource("data")
    @ParameterizedTest()
    public void solve(int[] A, int expect) {
        Triangle solver = new Triangle();
        int actual = solver.solution(A);
        assertEquals(expect, actual);
    }

    static Arguments[] data() {
        return new Arguments[]{
                // examples
                Arguments.of(new int[]{10, 2, 5, 1, 8, 20}, 1),
                Arguments.of(new int[]{10, 50, 5, 1}, 0),
                // extreme_arith_overflow1
                Arguments.of(new int[]{MIN_VALUE, MIN_VALUE, MIN_VALUE}, 0),
                Arguments.of(new int[]{MAX_VALUE, MAX_VALUE, MAX_VALUE}, 1),
                // custom
                Arguments.of(new int[]{}, 0),
        };
    }
}
