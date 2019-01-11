package edu.hackerrank.algorithms.sorting;

import java.util.Arrays;

/**
 * Fraudulent Activity Notifications.
 * https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem
 */
class FraudulentActivityNotifications {

    static int activityNotifications(int[] expenses, int days) {
        // sort initial median values
        int[] medians = Arrays.copyOfRange(expenses, 0, days);
        Arrays.sort(medians);

        int notifications = 0;
        for (int i = days; i < expenses.length; i++) {
            double median = medianOf(medians);
            if (expenses[i] >= median * 2.0)
                notifications++;

            // replace outdated value
            int v = expenses[i - days];
            int j = Arrays.binarySearch(medians, v);
            medians[j] = expenses[i];

            // bubble down
            for (; j > 0; j--) {
                if (medians[j] >= medians[j - 1]) break;
                else swap(medians, j, j - 1);
            }

            // bubble up
            for (int jmax = days - 1; j < jmax; j++) {
                if (medians[j] <= medians[j + 1]) break;
                else swap(medians, j, j + 1);
            }
        }

        return notifications;
    }

    private static double medianOf(int[] a) {
        int half = a.length / 2;
        return a.length % 2 == 1
                ? a[half]
                : (a[half - 1] + a[half]) * 0.5;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++)
            if (array[i - 1] > array[i])
                return false;
        return true;
    }
}
