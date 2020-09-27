package edu.codility.L07;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FishTest {
    @MethodSource("data")
    @ParameterizedTest()
    public void solve(int[] A, int[] B, int expect) {
        Fish solver = new Fish();
        int actual = solver.solution(A, B);
        assertEquals(expect, actual);
    }

    static Arguments[] data() {
        return new Arguments[]{
                // examples
                Arguments.of(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0}, 2),
        };
    }
}
