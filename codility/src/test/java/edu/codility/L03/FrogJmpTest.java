package edu.codility.L03;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

public class FrogJmpTest {
    @MethodSource("data")
    @ParameterizedTest()
    public void solve(int X, int Y, int D, int expect) {
        FrogJmp solver = new FrogJmp();
        int actual = solver.solution(X, Y, D);
        assertEquals(expect, actual);
    }

    static Arguments[] data() {
        return new Arguments[]{
                // examples
                of(10, 85, 30, 3)
        };
    }
}
