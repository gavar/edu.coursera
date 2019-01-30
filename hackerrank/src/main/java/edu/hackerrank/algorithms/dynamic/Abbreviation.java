package edu.hackerrank.algorithms.dynamic;

/**
 * Given two strings, a and b, determine if it's possible to make a equal to b as described.
 * If so, print YES on a new line. Otherwise, print NO.
 * You can perform the following operations on the string, a:
 * 1. Capitalize zero or more of a's lowercase letters.
 * 2. Delete all of the remaining lowercase letters in a.
 * <p>
 * https://www.hackerrank.com/challenges/abbr
 */
public class Abbreviation {

    static String abbreviation(String a, String b) {
        boolean[][] memo = new boolean[a.length() + 1][b.length() + 1];
        // 'A' is abbreviation of 'B' if both are empty
        memo[0][0] = true;

        // 'A' is abbreviation of 'B' if 'B' is empty, but 'A' has only lowercase letters
        for (int k = 1; k <= a.length(); k++)
            memo[k][0] = memo[k - 1][0] & Character.isLowerCase(a.charAt(k - 1));

        for (int ai = 1; ai <= a.length(); ai++) {
            for (int bi = 1; bi <= b.length(); bi++) {
                char ac = a.charAt(ai - 1);
                char bc = b.charAt(bi - 1);

                // characters are equal, rely on previous char
                if (bc == ac) {
                    memo[ai][bi] = memo[ai - 1][bi - 1];
                    continue;
                }

                // uppercase a == b, set = prev character bool. or just eat a.
                if (bc == Character.toUpperCase(ac)) {
                    memo[ai][bi] = memo[ai - 1][bi - 1] || memo[ai - 1][bi];
                    continue;
                }

                // a is uppercase and no more b, or uppercase a is not b, then false
                if (Character.isUpperCase(ac)) {
                    memo[ai][bi] = false;
                    continue;
                }

                // remove 'a'
                memo[ai][bi] = memo[ai - 1][bi];
            }
        }
        return memo[a.length()][b.length()] ? "YES" : "NO";
    }
}
