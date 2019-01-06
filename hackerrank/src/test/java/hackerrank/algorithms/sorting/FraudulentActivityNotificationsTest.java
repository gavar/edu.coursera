package hackerrank.algorithms.sorting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FraudulentActivityNotificationsTest {

    @ParameterizedTest
    @MethodSource("data")
    void activityNotifications(String fileName, int expect) throws IOException {
        Problem problem = parse(fileName);
        int days = problem.days;
        int[] expenses = problem.expenses;
        int actual = FraudulentActivityNotifications.activityNotifications(expenses, days);
        assertEquals(expect, actual);
    }

    private Problem parse(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(fileName);
        Scanner scanner = new Scanner(url.openStream());

        int size = scanner.nextInt();
        int days = scanner.nextInt();
        int[] expenses = new int[size];
        for (int i = 0; i < size; i++)
            expenses[i] = scanner.nextInt();

        Problem problem = new Problem();
        problem.expenses = expenses;
        problem.days = days;
        return problem;
    }

    private class Problem {
        int days;
        int[] expenses;
    }

    private static Object[][] data() {
        return new Object[][]{
                new Object[]{"algorithms.sorting/fraudulent-activity-notifications-0.txt", 2},
                new Object[]{"algorithms.sorting/fraudulent-activity-notifications-1.txt", 633},
                new Object[]{"algorithms.sorting/fraudulent-activity-notifications-6.txt", 0},
                new Object[]{"algorithms.sorting/fraudulent-activity-notifications-7.txt", 1},
        };
    }
}
