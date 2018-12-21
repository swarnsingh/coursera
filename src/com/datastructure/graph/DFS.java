package com.datastructure.graph;

import com.coursera.util.FastScanner;

import java.util.HashMap;
import java.util.Stack;

/*
Enter no. of vertices : 7
Enter no. of Edges : 11
1 2
1 4
1 5
2 3
2 5
3 5
3 6
3 7
4 5
5 6
6 7
*/

/**
 * @author Swarn Singh.
 */
public class DFS {

    private static HashMap<Integer, Boolean> mVisitedNodes;

    private static Stack<Integer> mStack;

    private static int vertices;

    private static int edges;

    private static int[][] adjacent;

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);

        System.out.print("Enter no. of vertices : ");
        vertices = scanner.nextInt();

        System.out.print("Enter no. of Edges : ");
        edges = scanner.nextInt();

        mVisitedNodes = new HashMap<>();

        int adjacentSize = vertices + 1;
        adjacent = new int[adjacentSize][adjacentSize];

        for (int i = 1; i <= edges; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();

            adjacent[v1][v2] = 1;
            adjacent[v2][v1] = 1;
        }

        mStack = new Stack<>();

        int firstElement = 1;
        mVisitedNodes.put(firstElement, true);
        mStack.push(firstElement);
        System.out.print("\n" + firstElement);
        depthFirstSearch(1);
        System.out.println();
    }

    public static void depthFirstSearch(int vertex) {

        for (int i = 1; i <= vertices; i++) {
            int v = adjacent[vertex][i];

            if (v == 1) {
                if (!mVisitedNodes.containsKey(i)) {
                    mVisitedNodes.put(i, true);
                    mStack.push(i);
                    System.out.print(" -> " + i);
                    depthFirstSearch(i);
                    break;
                }
            }
        }

        if (!mStack.isEmpty()) {
            mStack.pop();
            if (!mStack.isEmpty()) {
                depthFirstSearch(mStack.peek());
            } else {
                return;
            }
        } else {
            return;
        }
    }

}
