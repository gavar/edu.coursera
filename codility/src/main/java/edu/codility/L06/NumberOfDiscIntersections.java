package edu.codility.L06;

import java.util.Arrays;

public class NumberOfDiscIntersections {
    public int solution(int[] A) {
        final int MAX = 10000000;
        int N = A.length;

        // convert to intervals
        Interval[] intervals = new Interval[N];
        for (int i = 0; i < N; i++) {
            final long r = A[i];
            intervals[i] = new Interval(i - r, i + r);
        }

        // sort by starting point
        Arrays.sort(intervals);

        int intersects = 0;
        Interval key = new Interval();
        for (int i = 0; i < N; i++) {
            // find closest point starting at the interval end
            key.sp = intervals[i].ep;
            int k = Arrays.binarySearch(intervals, i, N, key);

            // normalize position return by binary search
            if (k < 0)
                k = Math.min(N - 1, ~k);

            // exclude intervals starting after
            while (k >= 0 && key.sp < intervals[k].sp)
                k--;

            // include all intervals starting from the end point
            while (k < N - 1 && key.sp == intervals[k + 1].sp)
                k++;

            intersects += k - i;
            if (intersects > MAX)
                return -1;
        }

        return intersects;
    }

    static class Interval implements Comparable<Interval> {
        public long sp; // starting point
        public long ep; // ending point

        public Interval() { }
        public Interval(long sp, long ep) {
            this.sp = sp;
            this.ep = ep;
        }

        @Override
        public int compareTo(Interval o) {
            return Long.compare(sp, o.sp);
        }

        @Override
        public int hashCode() {
            return Long.hashCode(sp);
        }

        @Override
        public String toString() {
            return "[" + sp + "; " + ep + ']';
        }
    }
}
