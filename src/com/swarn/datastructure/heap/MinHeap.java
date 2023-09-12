package com.swarn.datastructure.heap;

/**
 * @author Swarn Singh.
 */
public class MinHeap {

    private final int[] heap;

    private final int capacity;

    private int size;

    private boolean isRootInserted = false;

    public MinHeap(int capacity) {
        this.heap = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    private void swap(int currentPos, int parentPos) {
        int temp = heap[currentPos];
        heap[currentPos] = heap[parentPos];
        heap[parentPos] = temp;
    }

    private void insert(int element) {
        if (size + 1 >= capacity) {
            System.out.println("Heap is full!");
            return;
        }

        if (size == 0 && !isRootInserted) {
            heap[size] = element;
            isRootInserted = true;
            return;
        }

        heap[++size] = element;
        int currentPos = size;

        while (heap[currentPos] < heap[(parent(currentPos))]) {
            swap(currentPos, parent(currentPos));
            currentPos = parent(currentPos);
        }

    }

    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos) + 1;
    }

    private int rightChild(int pos) {
        return (2 * pos) + 2;
    }

    private boolean isLeaf(int pos) {
        return pos >= (size / 2) && pos <= size;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(7);
        minHeap.insert(8);
        minHeap.insert(4);
        minHeap.insert(10);
        minHeap.insert(16);
        minHeap.insert(12);
        minHeap.insert(5);

        for (int e : minHeap.heap) {
            System.out.print(e + " ");
        }
    }
}
