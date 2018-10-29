package edu.cs.algorithms.queue;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Program that takes an integer k as a command-line argument;
 * reads in a sequence of strings from standard input using StdIn.readString();
 * and prints exactly k of them, uniformly at random. Print each item from the sequence at most once.
 * <p>
 * Command-line input.
 * You may assume that 0 ≤ k ≤ n, where n is the number of string on standard input.
 * <p>
 * Performance requirements.
 * The running time of Permutation must be linear in the size of the input. You may use only a constant amount
 * of memory plus either one Deque or RandomizedQueue object of maximum size at most n. (For an extra challenge,
 * use only one Deque or RandomizedQueue object of maximum size at most k.)
 */
public class Permutation {

    public static void main(String[] args) {
        if (args.length != 1)
            throw new IllegalArgumentException("invalid number of arguments");

        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        while (StdIn.hasNextLine())
            rq.enqueue(StdIn.readLine());

        while (--k >= 0)
            StdOut.println(rq.dequeue());
    }
}
