package edu.codility.L07;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NestingTest {
    @MethodSource("data")
    @ParameterizedTest()
    public void solve(String S, int expect) {
        Nesting solver = new Nesting();
        int actual = solver.solution(S);
        assertEquals(expect, actual);
    }

    static Arguments[] data() {
        return new Arguments[]{
                // examples
                Arguments.of("", 1),
                Arguments.of("(U)", 1),
                Arguments.of("VW", 1),
                Arguments.of("(()(())())", 1),
                Arguments.of("())", 0),
        };
    }
}
