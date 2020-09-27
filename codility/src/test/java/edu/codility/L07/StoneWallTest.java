package edu.codility.L07;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoneWallTest {
    @MethodSource("data")
    @ParameterizedTest()
    public void solve(int[] H, int expect) {
        StoneWall solver = new StoneWall();
        int actual = solver.solution(H);
        assertEquals(expect, actual);
    }

    static Arguments[] data() {
        return new Arguments[]{
                // examples
                Arguments.of(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8}, 7),
        };
    }
}
