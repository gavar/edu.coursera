package edu.toptal.D20200910;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

public class Task1Test {
    @MethodSource("data")
    @ParameterizedTest(name = "N = {0}")
    public void solve(String S, int[] X, int[] Y, int expect) {
        Task1 solver = new Task1();
        int actual = solver.solution(S, X, Y);
        assertEquals(expect, actual);
    }

    static Arguments[] data() {
        return new Arguments[]{
                // examples
                of("ABDCA", new int[]{2, -1, -4, -3, 3}, new int[]{2, -2, 4, 1, -3}, 3),
                of("ABB", new int[]{1, -2, -2}, new int[]{1, -2, 2}, 1),
                of("CCD", new int[]{1, -1, 2}, new int[]{1, -1, -2}, 0),
        };
    }
}
