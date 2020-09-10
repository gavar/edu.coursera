package edu.toptal.D20200910;

public class Task2 {
    public int solution(String S, int K) {
        int N = S.length();
        Node left = new Node('\0');
        Node right = new Node('\0');

        // trim beginning
        Node tail = right;
        for (int i = K; i < N; i++)
            tail = tail.offer(S.charAt(i));
        right = right.next;

        int min = N;
        for (int i = 0, j = K; j < N; i++, j++) {
            final int size = merge(left, right);
            min = Math.min(min, size);
            left = left.offer(S.charAt(i));
            right = right.poll();
        }

        return min;
    }

    int merge(Node left, Node right) {
        while (left != null && left.count == 0)
            left = left.prev;

        while (right != null && right.count == 0)
            right = right.next;

        if (left == null) return sumRight(right);
        if (right == null) return sumLeft(left);

        return left.c != right.c
                ? sumLeft(left) + sumRight(right)
                : sumLeft(left.prev) + widthOf(left.count + right.count) + sumRight(right.next);
    }

    int sumLeft(Node node) {
        int total = 0;
        while (node != null) {
            total += node.width;
            node = node.prev;
        }
        return total;
    }

    int sumRight(Node node) {
        int total = 0;
        while (node != null) {
            total += node.width;
            node = node.next;
        }
        return total;
    }

    int widthOf(int count) {
        return count > 2
                ? digits(count) + 1
                : count;
    }

    int digits(int number) {
        int count = 1;
        for (int t = 10; t < number; t *= 10)
            count++;
        return count;
    }

    class Node {
        final char c;
        public Node(char c) {
            this.c = c;
        }

        Node prev;
        Node next;

        int count;
        int width;

        Node offer(char c) {
            if (this.c == c) {
                width = widthOf(++this.count);
                return this;
            } else {
                next = new Node(c);
                next.count = 1;
                next.width = 1;
                next.prev = this;
                return next;
            }
        }

        Node poll() {
            width += widthOf(--this.count);

            Node node = this;
            while (node != null && node.count < 1)
                node = node.next;

            return node;
        }
    }
}
