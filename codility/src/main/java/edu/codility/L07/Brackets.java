package edu.codility.L07;

import java.util.*;

public class Brackets {

    static final Map<Character, Character> pairs = new HashMap<Character, Character>() {{
        put('{', '}');
        put('(', ')');
        put('[', ']');
    }};

    static final Set<Character> closings = new HashSet<>(pairs.values());

    public int solution(String S) {
        final int N = S.length();
        Stack<Character> pending = new Stack<>();
        for (int i = 0; i < N; i++) {
            Character c = S.charAt(i);
            if (closings.contains(c)) {
                if (pending.isEmpty()) return 0;
                if (pending.pop() != c) return 0;
            } else {
                final Character closing = pairs.get(S.charAt(i));
                if (closing != null) pending.push(closing);
            }
        }

        return pending.isEmpty() ? 1 : 0;
    }
}
