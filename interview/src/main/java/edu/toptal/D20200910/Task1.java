package edu.toptal.D20200910;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Task1 {
    public int solution(String S, int[] X, int[] Y) {
        int N = S.length();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            points[i] = new Point();
            points[i].name = S.charAt(i);
            points[i].distance = X[i] * X[i] + Y[i] * Y[i];
        }
        Arrays.sort(points);

        int total = 0;
        Set<Character> names = new HashSet<>();

        for (int i = 0; i < N; ) {
            Point point = points[i++];
            if (!names.add(point.name))
                return total;

            int count = 1;
            while (i < N && points[i].distance == point.distance) {
                if (!names.add(point.name)) return total;
                count++;
                i++;
            }

            total += count;
        }

        return total;
    }

    class Point implements Comparable<Point> {
        char name;
        long distance;

        public int compareTo(Point o) {
            return Long.compare(distance, o.distance);
        }
    }

    // class Location {
    //     long distance;
    //     List<String> points;
    // }
}
