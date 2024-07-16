package com.swarn.datastructure.graph;

import java.util.*;

/**
 * Class representing a generic Breadth-First Search (BFS) implementation for a directed graph.
 *
 * @param <T> the type of the vertices
 * @author Swarn Singh
 */

public class BreadthFirstSearch<T> {

    // Adjacency list to represent the graph
    private LinkedHashMap<T, List<Edge<T>>> adjacencyList;

    /**
     * Class representing an edge in the graph.
     *
     * @param <T> the type of the vertices
     */
    private static class Edge<T> {
        T startVertex;
        T endVertex;
        int weight;

        /**
         * Constructor for the Edge class.
         *
         * @param startVertex the starting vertex of the edge
         * @param endVertex   the ending vertex of the edge
         * @param weight      the weight of the edge
         */
        public Edge(T startVertex, T endVertex, int weight) {
            this.startVertex = startVertex;
            this.endVertex = endVertex;
            this.weight = weight;
        }
    }

    /**
     * Method to add edges to the graph.
     *
     * @param edges a 2D array where each sub-array represents an edge with the first element as the start vertex,
     *              the second element as the end vertex, and the third element as the weight of the edge
     */
    private void addAll(Object[][] edges) {
        adjacencyList = new LinkedHashMap<>(edges.length);
        for (Object[] edge : edges) {
            T startVertex = (T) edge[0];
            T endVertex = (T) edge[1];
            int weight = (Integer) edge[2];

            Edge<T> item = new Edge(startVertex, endVertex, weight);
            adjacencyList.computeIfAbsent(startVertex, k -> new ArrayList<>()).add(item);
        }
    }

    /**
     * Method to perform Breadth-First Search (BFS) on the graph starting from the given vertex.
     * The time complexity of this method is O(V + E), where V is the number of vertices and E is the number of edges.
     *
     * @param startVertex the starting vertex for the BFS
     */
    public <T> void breadthFirstSearch(T startVertex) {
        Set<T> visited = new HashSet<>();
        LinkedList<T> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            T vertex = queue.poll();
            System.out.print(vertex + " ");

            List<Edge<T>> edges = adjacencyList.getOrDefault(vertex, new ArrayList());
            for (Edge<T> edge : edges) {
                if (!visited.contains(edge.endVertex)) {
                    visited.add(edge.endVertex);
                    queue.add(edge.endVertex);
                }
            }
        }
    }

    /**
     * Main method to demonstrate the BFS implementation.
     */
    public static void main(String[] args) {
        Object[][] edges = {
                {0, 1, 5}, {0, 2, 7}, {0, 3, 3}, {1, 4, 2}, {1, 5, 10}, {2, 6, 1}, {3, 7, 11}, {4, 7, 9},
                {5, 7, 4}, {6, 7, 6}, {7, 0, 3}
        };
        BreadthFirstSearch<Integer> bfs = new BreadthFirstSearch<>();
        bfs.addAll(edges);

        int startVertex = 0;
        System.out.print("BFS starting from vertex " + startVertex + " :-> ");
        bfs.breadthFirstSearch(startVertex);

        Object[][] charEdges = {
                {'A', 'B', 5}, {'A', 'C', 7}, {'A', 'D', 3}, {'B', 'E', 2}, {'B', 'F', 10},
                {'C', 'G', 1}, {'D', 'H', 11}, {'E', 'H', 9}, {'F', 'H', 4}, {'G', 'H', 6},
                {'H', 'A', 3}
        };

        bfs = new BreadthFirstSearch<>();
        bfs.addAll(charEdges);

        char startCharVertex = 'F';
        System.out.print("\n\nBFS starting from vertex " + startCharVertex + " :-> ");
        bfs.breadthFirstSearch(startCharVertex);
    }
}
