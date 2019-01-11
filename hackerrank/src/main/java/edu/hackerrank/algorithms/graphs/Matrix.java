package edu.hackerrank.algorithms.graphs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Matrix {

    static int minTime(int[][] roads, int[] machines) {
        int n = roads.length + 1;

        // union-find
        int[] uf = new int[n];
        for (int i = 0; i < n; i++)
            uf[i] = i;

        // mark city with machines
        boolean[] connections = new boolean[n];
        for (int city : machines)
            connections[city] = true;

        // sort connections by their time ascending,
        // so we could leave most expensive machines connected
        Arrays.sort(roads, Collections.reverseOrder(Comparator.comparingInt(x -> x[2])));

        int totalTime = 0;
        for (int[] road : roads) {
            int a = find(uf, road[0]);
            int b = find(uf, road[1]);

            // number of machines in segments after merging
            int m = 0;
            if (connections[a]) m++;
            if (connections[b]) m++;

            if (m > 1) {
                // we don't want to connect regions
                // to form connection having more then 1 machine
                totalTime += road[2];
            } else {
                uf[b] = a;
                connections[a] = m > 0;
                connections[b] = m > 0;
            }
        }

        return totalTime;
    }

    private static int find(int[] uf, int node) {
        while (node != uf[node]) {
            uf[node] = uf[uf[node]];
            node = uf[node];
        }
        return node;
    }
}
