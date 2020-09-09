package edu.codility.L03;

public class FrogJmp {
    public int solution(int X, int Y, int D) {
        int dist = Y - X;
        int count = dist / D;
        if (dist % D > 0) count++;
        return count;
    }
}
