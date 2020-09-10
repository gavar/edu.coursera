package edu.toptal.D20200910;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

public class Task3Test {
    @MethodSource("data")
    @ParameterizedTest()
    public void solve(String S, int expect) {
        Task3 solver = new Task3();
        int actual = solver.solution(S);
        assertEquals(expect, actual);
    }

    static Arguments[] data() {
        return new Arguments[]{
                // examples
                of("babaa", 2),
                of("ababa", 4),
                of("aba", 0),
                of("bbbbb", 6),
                // custom
                of("bbbbbb", 10),
                of("abababababa", 4),
                of("abbabbababbaba", 9),
                of("abbabbbababbaba", 12),
        };
    }
}

// abababababa
// 1. aba|baba|baba
// 2. aba|babab|aba
// 3. abab|aba|baba
// 4. abab|abab|aba

// abbabbababbaba
// 1. abba|bbaba|bbaba
// 2. abba|bbabab|baba
// 3. abba|bbababb|aba
// 4. abbab|baba|bbaba
// 5. abbab|babab|baba
// 6. abbab|bababb|aba
// 7. abbabb|aba|bbaba
// 8. abbabb|abab|baba
// 9. abbabb|ababb|aba

// abbabbbababbaba
//  1. abba|bbbababb|aba
//  2. abba|bbbabab|baba
//  3. abba|bbbaba|bbaba
//  4. abbab|bbababb|aba
//  5. abbab|bbabab|baba
//  6. abbab|bbaba|bbaba
//  7. abbabb|bababb|aba
//  8. abbabb|babab|baba
//  9. abbabb|baba|bbaba
// 10. abbabbb|ababb|aba
// 11. abbabbb|abab|baba
// 12. abbabbb|aba|bbaba

// bbbbb
// 1. b|bbb|b
// 2. b|bb|bb
// 3. b|b|bbb
// 4. bb|bb|b
// 5. bb|b|bb
// 6. bbb|b|b

// bbbbbb
//  1. b|b|bbbb
//  2. b|bb|bbb
//  3. b|bbb|bb
//  4. b|bbbb|b
//  5. bb|b|bbb
//  6. bb|bb|bb
//  7. bb|bbb|b
//  8. bbb|b|bb
//  9. bbb|bb|b
// 10. bbbb|b|b
