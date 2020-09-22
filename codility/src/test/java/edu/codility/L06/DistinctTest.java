package edu.codility.L06;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistinctTest {
    @MethodSource("data")
    @ParameterizedTest()
    public void solve(int[] A, int expect) {
        Distinct solver = new Distinct();
        int actual = solver.solution(A);
        assertEquals(expect, actual);
    }

    static Arguments[] data() {
        return new Arguments[]{
                // examples
                Arguments.of(new int[]{2, 1, 1, 2, 3, 1}, 3)
        };
    }
}
