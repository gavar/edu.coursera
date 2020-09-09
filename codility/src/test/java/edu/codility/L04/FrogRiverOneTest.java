package edu.codility.L04;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

public class FrogRiverOneTest {
    @MethodSource("data")
    @ParameterizedTest()
    public void solve(int X, int[] A, int expect) {
        FrogRiverOne solver = new FrogRiverOne();
        int actual = solver.solution(X, A);
        assertEquals(expect, actual);
    }

    static Arguments[] data() {
        return new Arguments[]{
                // examples
                of(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}, 6)
        };
    }
}
