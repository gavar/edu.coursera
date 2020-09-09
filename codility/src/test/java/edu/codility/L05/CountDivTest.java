package edu.codility.L05;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

public class CountDivTest {
    @MethodSource("data")
    @ParameterizedTest()
    public void solve(int A, int B, int K, int expect) {
        CountDiv solver = new CountDiv();
        int actual = solver.solution(A, B, K);
        assertEquals(expect, actual);
    }

    static Arguments[] data() {
        return new Arguments[]{
                // examples
                of(6, 11, 2, 3),
                // simple
                of(11, 345, 17, 20),
                // minimal
                of(1, 1, 11, 0),
                of(0, 0, 11, 1),
                // extreme
                of(10, 10, 5, 1),
                of(10, 10, 7, 0),
                of(10, 10, 20, 0),
                // performance
                of(100, 123456788, 2, 61728345),
                of(101, 123450101, 10000, 12345),
                of(0, 2000000000, 1, 2000000001),
                of(0, 2000000000, 2000000000, 2),
                of(1, 1, 1, 1),
                of(1, 2000000000, 1, 2000000000),
                of(1, 2000000000, 2000000000, 1),
                of(2000000000, 2000000000, 2000000000, 1),
        };
    }
}
