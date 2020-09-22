package edu.codility.L06;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxProductOfThreeTest {
    @MethodSource("data")
    @ParameterizedTest()
    public void solve(int[] A, int expect) {
        MaxProductOfThree solver = new MaxProductOfThree();
        int actual = solver.solution(A);
        assertEquals(expect, actual);
    }

    static Arguments[] data() {
        return new Arguments[]{
                // examples
                Arguments.of(new int[]{-3, 1, 2, -2, 5, 6}, 60),
                // custom
                Arguments.of(new int[]{-100, -50, 2, -2, 5, 6}, 30000),
        };
    }
}
