package edu.toptal.D20200910;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

public class Task3Test {
    @MethodSource("data")
    @ParameterizedTest(name = "N = {0}")
    public void solve(int[] A, int expect) {
        Task3 solver = new Task3();
        int actual = solver.solution(A);
        assertEquals(expect, actual);
    }

    static Arguments[] data() {
        return new Arguments[]{
                // examples
                of(new int[]{}, 0),
        };
    }
}
