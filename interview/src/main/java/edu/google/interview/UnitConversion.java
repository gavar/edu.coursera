package edu.google.interview;

import java.util.*;

/**
 * Phone interview question.
 * Date: 31.10.2018
 * <p>
 * Task:
 * 12 EUR  in USD     => 14.16 USD
 * 2 Yards in Meters  => 1.828 Meters
 * <p>
 * Input 1: ratio records
 * Source | Ratio  | Destination
 * GBP    | 0.69   | USD
 * Yard   | 1.09   | Meter
 * EUR    | 0.0077 | YEN
 * YEN    | 167.75 | GBP
 * <p>
 * Input 2: batch of queries
 * Source | Destination
 * EUR    | USD
 * Meter  | Yard
 * <p>
 * Output:
 * Source | Ratio | Destination
 * EUR    | 0.89  | USD
 * Meter  | 0.91  | Yard
 */
class UnitConversion {

    static double[] convert(String[] sources, double[] ratios, String[] destinations, String[][] queries) {
        Graph graph = new Graph();
        for (int i = 0; i < sources.length; i++)
            graph.connect(sources[i], ratios[i], destinations[i]);
        return convert(graph, queries);
    }

    static double[] convert(Graph graph, String[][] queries) {
        double[] output = new double[queries.length];
        for (int i = 0; i < queries.length; i++)
            output[i] = convert(graph, queries[i][0], queries[i][1]);
        return output;
    }

    static double convert(Graph graph, String from, String to) {
        Node node = graph.nodes.get(from);
        if (node == null) return -1;
        Set<Node> visits = new HashSet<>();
        return dfs(node, to, 1.0, visits);
    }

    static double dfs(Node node, String to, double total, Set<Node> visits) {
        if (node.unit.equals(to)) return total;
        if (!visits.add(node)) return -1;

        for (Ratio ratio : node.ratios) {
            double r = dfs(ratio.to, to, total * ratio.value, visits);
            if (r > 0) return r;
        }

        return -1;
    }

    static class Graph {
        Map<String, Node> nodes = new HashMap<>();

        Node require(String unit) {
            Node node = nodes.get(unit);
            if (node != null) return node;
            node = new Node(unit);
            nodes.put(unit, node);
            return node;
        }

        void connect(String source, double ratio, String destination) {
            Node a = require(source);
            Node b = require(destination);
            a.ratios.add(new Ratio(b, ratio));
            b.ratios.add(new Ratio(a, 1.0 / ratio));
        }
    }

    static class Node {
        String unit;
        List<Ratio> ratios = new ArrayList<>();

        Node(String unit) {
            this.unit = unit;
        }
    }

    static class Ratio {
        Node to;
        double value;

        Ratio(Node to, double value) {
            this.to = to;
            this.value = value;
        }
    }
}
