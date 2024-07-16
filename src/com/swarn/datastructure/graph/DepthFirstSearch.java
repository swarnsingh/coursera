package com.swarn.datastructure.graph;

import java.util.*;

/**
 * Class representing a Depth First Search (DFS) implementation for a graph.
 *
 * @param <T> the type of the vertices
 * @author Swarn Singh
 */
public class DepthFirstSearch<T> {

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

            Edge<T> item = new Edge<>(startVertex, endVertex, weight);
            adjacencyList.computeIfAbsent(startVertex, k -> new ArrayList<>()).add(item);
        }
    }

    /**
     * Method to perform depth first search starting from the specified vertex.
     *
     * @param startVertex the starting vertex for the DFS
     */
    public void depthFirstSearch(T startVertex) {
        Set<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();

        visited.add(startVertex);
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            T vertex = stack.pop();
            System.out.print(vertex + " ");

            List<Edge<T>> edges = adjacencyList.getOrDefault(vertex, new ArrayList<>());
            for (Edge<T> edge : edges) {
                if (!visited.contains(edge.endVertex)) {
                    visited.add(edge.endVertex);
                    stack.push(edge.endVertex);
                }
            }
        }
    }

    /**
     * Method to perform topological sort on the graph.
     * This method sorts the vertices of a directed acyclic graph (DAG) in a linear order
     * such that for every directed edge u -> v, vertex u comes before v in the ordering.
     *
     * @return an array of vertices in topologically sorted order
     */
    public T[] topologicalSort() {
        Set<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();

        for (T vertex : adjacencyList.keySet()) {
            if (!visited.contains(vertex)) {
                dfs(vertex, stack, visited);
            }
        }

        T[] answer = (T[]) new Object[adjacencyList.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            answer[i++] = stack.pop();
        }

        return answer;
    }

    /**
     * Helper method for DFS used in topological sort.
     * This method recursively visits all the unvisited vertices reachable from the startVertex,
     * marking them as visited and pushing them onto the stack once all their neighbors are processed.
     *
     * @param startVertex the starting vertex for the DFS
     * @param stack       the stack to hold the vertices in topologically sorted order
     * @param visited     the set to keep track of visited vertices
     */
    private void dfs(T startVertex, Stack<T> stack, Set<T> visited) {
        visited.add(startVertex);
        for (Edge<T> edge : adjacencyList.getOrDefault(startVertex, new ArrayList<>())) {
            if (!visited.contains(edge.endVertex)) {
                dfs(edge.endVertex, stack, visited);
            }
        }
        stack.push(startVertex);
    }

    public static void main(String[] args) {
        Object[][] edges = {
                {0, 1, 5}, {0, 2, 7}, {0, 3, 3}, {1, 4, 2}, {1, 5, 10}, {2, 6, 1}, {3, 7, 11}, {4, 7, 9},
                {5, 7, 4}, {6, 7, 6}, {7, 0, 3}
        };
        DepthFirstSearch<Integer> dfs = new DepthFirstSearch<>();
        dfs.addAll(edges);

        dfs.depthFirstSearch(0);

        Object[] arr = dfs.topologicalSort();
        System.out.println("\n\n");
        for (Object i : arr) {
            System.out.print(i + " ");
        }
    }
}
