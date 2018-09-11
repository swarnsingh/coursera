package com.coursera.heap;

/**
 * @author Swarn Singh.
 */
public class MaxHeap {

    private int[] heap;

    private int capacity;

    private int size;

    private boolean isRootInserted = false;

    public MaxHeap(int capacity) {
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

        while (heap[currentPos] > heap[(parent(currentPos))]) {
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
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(3);
        maxHeap.insert(2);
        maxHeap.insert(1);
        maxHeap.insert(7);
        maxHeap.insert(8);
        maxHeap.insert(4);
        maxHeap.insert(10);
        maxHeap.insert(16);
        maxHeap.insert(12);
        maxHeap.insert(5);

        for (int e : maxHeap.heap) {
            System.out.print(e + " ");
        }
    }

}
