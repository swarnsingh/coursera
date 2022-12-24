package com.swarn.datastructure.graph;

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

import com.swarn.coursera.util.FastScanner;

import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Swarn Singh.
 */
public class BFS {
    private static HashMap<Integer, Boolean> mVisitedNodes;
    private static Queue<Integer> mQueue;
    private static int vertices;
    private static int edges;
    private static int[][] adjacent;

    private static void breadthFirstSearch(int vertex) {
        for (int i = 1; i <= vertices; i++) {
            int path = adjacent[vertex][i];

            if (path == 1) {
                if (!mVisitedNodes.containsKey(i)) {
                    mQueue.add(i);
                    mVisitedNodes.put(i, true);
                    System.out.print(" -> " + i);
                }
            }
        }

        if (!mQueue.isEmpty()) {
            mQueue.remove();
            if (!mQueue.isEmpty()) {
                breadthFirstSearch(mQueue.peek());
            }
        }
    }

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);

        System.out.print("Enter no. of vertices : ");
        vertices = fastScanner.nextInt();

        System.out.print("Enter no. of Edges : ");
        edges = fastScanner.nextInt();

        mVisitedNodes = new HashMap<>();

        int adjacentSize = vertices + 1;
        adjacent = new int[adjacentSize][adjacentSize];

        for (int i = 1; i <= edges; i++) {
            int vx1 = fastScanner.nextInt();
            int vx2 = fastScanner.nextInt();

            adjacent[vx1][vx2] = 1;
            adjacent[vx2][vx1] = 1;
        }

        int startingElement = 1;
        mVisitedNodes.put(startingElement, true);
        mQueue = new ConcurrentLinkedQueue<>();
        mQueue.add(startingElement);
        System.out.print("\n" + startingElement);
        breadthFirstSearch(startingElement);
        System.out.println();
    }
}
