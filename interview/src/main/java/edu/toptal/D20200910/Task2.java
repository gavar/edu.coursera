package edu.toptal.D20200910;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Task2 {
    public int solution(String S, int K) {
        int N = S.length();
        List<Character> chars = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();

        for (int i = 0; i < N; ) {
            int count = 1;
            char c = S.charAt(i++);
            while (i < N && S.charAt(i) == c) {
                count++;
                i++;
            }

            chars.add(c);
            counts.add(count);
        }

        int p = 0;

        // remove first K chars
        Deque<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < K; ) {
            int count = counts.get(p);
            if (count > 0) {
                i++;
                count--;
                queue.add(p);
                counts.set(p, count);
            } else {
                p++;
            }
        }

        int min = compress(chars, counts);
        for (int i = K; i < N; ) {
            // restore
            int m = queue.poll();
            counts.set(m, counts.get(m) + 1);

            // remove next
            int count = counts.get(p);
            if (count > 0) {
                i++;
                count--;
                queue.add(p);
                counts.set(p, count);
                int size = compress(chars, counts);
                min = Math.min(min, size);
            } else {
                p++;
            }
        }

        return min;
    }

    int compress(List<Character> chars, List<Integer> counts) {
        int total = 0;

        int batch = 0;
        char last = 0;

        for (int i = 0; i < chars.size(); i++) {
            char c = chars.get(i);
            int count = counts.get(i);
            if (count == 0) continue;
            if (c == last) {
                batch += count;
            } else {
                if (batch > 2) total += digits(batch) + 1;
                else total += batch;
                batch = count;
            }
        }

        if (batch > 2) total += digits(batch) + 1;
        else total += batch;
        return total;
    }

    int digits(int num) {
        int count = 0;
        for (; num != 0; num /= 10, ++count) ;
        return count;
    }
}
