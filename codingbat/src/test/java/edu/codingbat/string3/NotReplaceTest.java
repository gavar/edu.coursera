package edu.codingbat.string3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotReplaceTest {

    @ParameterizedTest
    @MethodSource("data")
    public void solve(String value, String expect) {
        NotReplace solver = new NotReplace();
        String actual = solver.notReplace(value);
        assertEquals(expect, actual);
    }

    static String[][] data() {
        return new String[][]{
                new String[]{"is test", "is not test"},
                new String[]{"is-is", "is not-is not"},
                new String[]{"This is right", "This is not right"},
                new String[]{"This is isabell", "This is not isabell"},
                new String[]{"", ""},
                new String[]{"is", "is not"},
                new String[]{"isis", "isis"},
                new String[]{"Dis is bliss is", "Dis is not bliss is not"},
                new String[]{"is his", "is not his"},
                new String[]{"xis yis", "xis yis"},
                new String[]{"AAAis is", "AAAis is not"},
        };
    }
}
