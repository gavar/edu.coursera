package edu.codility.L05;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

public class GenomicRangeQueryTest {
    @MethodSource("data")
    @ParameterizedTest()
    public void solve(String S, int[] P, int[] Q, int[] expect) {
        GenomicRangeQuery solver = new GenomicRangeQuery();
        int[] actual = solver.solution(S, P, Q);
        assertArrayEquals(expect, actual);
    }

    static Arguments[] data() {
        return new Arguments[]{
                // examples
                of("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}, new int[]{2, 4, 1}),
        };
    }
}
