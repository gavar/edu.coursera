package edu.toptal.D20200910;

public class Task3 {
    public int solution(String S) {
        int N = S.length();

        // total numbers of 'a' in array
        int total = 0;
        for (int i = 0; i < N; i++)
            if (S.charAt(i) == 'a')
                total++;

        // all possible permutations
        if (total == 0)
            return (N - 2) * (N - 1) / 2;

        // not possible if has remainder
        if (total % 3 > 0) return 0;
        int count = total / 3;

        // find leftmost bound
        int L = find(S, count);
        if (L < 0) return 0;

        // count LEFT permutations
        int LP = 1;
        for (L++; S.charAt(L) != 'a'; L++)
            LP++;

        // find rightmost bound
        int R = findLast(S, count);
        if (R < 0) return 0;

        // count RIGHT permutations
        int RP = 1;
        for (R--; S.charAt(R) != 'a'; R--)
            RP++;

        // RIGHT permutation for every LEFT permutation
        return RP * LP;
    }

    private int find(String S, int repeats) {
        for (int i = 0; i < S.length(); i++)
            if (S.charAt(i) == 'a')
                if (--repeats == 0)
                    return i;
        return -1;
    }

    private int findLast(String S, int repeats) {
        for (int i = S.length() - 1; i >= 0; i--)
            if (S.charAt(i) == 'a')
                if (--repeats == 0)
                    return i;
        return -1;
    }
}
