package edu.toptal.D20200910;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

public class Task2Test {
    @MethodSource("data")
    @ParameterizedTest(name = "N = {0}")
    public void solve(String S, int K, int expect) {
        Task2 solver = new Task2();
        int actual = solver.solution(S, K);
        assertEquals(expect, actual);
    }

    static Arguments[] data() {
        return new Arguments[]{
                // examples
                of("ABBBCCDDCCC", 3, 5),
                of("AAAAAAAAAAABXXAAAAAAAAAA", 3, 3),
                of("AAAAAAAAAABXXAAAAAAAAAA", 3, 3),
                of("ABCDDDEFG", 2, 6),
        };
    }
}
