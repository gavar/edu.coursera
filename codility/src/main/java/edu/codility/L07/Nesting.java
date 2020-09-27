package edu.codility.L07;

public class Nesting {
    public int solution(String S) {
        int N = S.length();
        int open = 0;

        for (int i = 0; i < N; i++) {
            switch (S.charAt(i)) {
                case '(':
                    open++;
                    break;
                case ')':
                    if (--open < 0) return 0;
                    break;
            }
        }

        return open == 0 ? 1 : 0;
    }
}
