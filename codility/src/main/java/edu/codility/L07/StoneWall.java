package edu.codility.L07;

import java.util.Stack;

public class StoneWall {
    public int solution(int[] H) {
        int blocks = 0;
        Stack<Integer> wall = new Stack<>();

        for (int height : H) {
            while (!wall.isEmpty() && wall.peek() > height) {
                wall.pop();
                blocks++;
            }

            if (wall.isEmpty() || wall.peek() < height) {
                wall.push(height);
            }
        }

        return blocks + wall.size();
    }
}
