package edu.toptal.D20200910;

import java.util.*;

public class Task1 {
    public int solution(String S, int[] X, int[] Y) {
        SortedMap<Long, List<Character>> locations = new TreeMap<>();

        for (int i = 0, N = S.length(); i < N; i++) {
            long distance = X[i] * X[i] + Y[i] * Y[i];
            List<Character> points = locations.get(distance);
            if (points == null) {
                points = new LinkedList<>();
                locations.put(distance, points);
            }
            points.add(S.charAt(i));
        }

        int total = 0;
        Set<Character> points = new HashSet<>();
        for (List<Character> batch : locations.values())
            if (merge(points, batch)) total += batch.size();
            else break;

        return total;
    }

    private <T> boolean merge(Set<T> target, Iterable<T> items) {
        for (T item : items)
            if (!target.add(item))
                return false;
        return true;
    }
}
