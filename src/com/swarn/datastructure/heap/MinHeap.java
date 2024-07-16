package com.swarn.datastructure.heap;

/**
 * MinHeap is a class that implements a minimum heap data structure.
 * A min heap is a binary tree where the value of each node is greater than or equal to
 * the value of its parent, with the minimum value at the root.
 *
 * Example usage:
 * MinHeap minHeap = new MinHeap(10);
 * minHeap.insert(3);
 * minHeap.insert(2);
 * minHeap.insert(1);
 * // and so on...
 *
 * The heap array after the above insertions would be a min-heap structure.
 *
 * @author Swarn Singh
 */
public class MinHeap {

    // Array to hold the heap elements
    private int[] heap;

    // Maximum capacity of the heap
    private int capacity;

    // Current size of the heap
    private int size;

    // Flag to check if the root is inserted
    private boolean isRootInserted = false;

    /**
     * Constructor to initialize the heap with a specified capacity.
     * @param capacity the maximum capacity of the heap
     */
    public MinHeap(int capacity) {
        this.heap = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    /**
     * Swaps two elements in the heap.
     * @param currentPos the current position of the element to be swapped
     * @param parentPos the position of the parent element to be swapped with
     */
    private void swap(int currentPos, int parentPos) {
        int temp = heap[currentPos];
        heap[currentPos] = heap[parentPos];
        heap[parentPos] = temp;
    }

    /**
     * Resizes the heap array when it is full.
     */
    private void resize() {
        int newCapacity = capacity * 2;
        int[] newHeap = new int[newCapacity];
        System.arraycopy(heap, 0, newHeap, 0, capacity);
        heap = newHeap;
        capacity = newCapacity;
    }

    /**
     * Inserts an element into the heap.
     * @param element the element to be inserted
     */
    public void insert(int element) {
        // Check if the heap is full and resize if necessary
        if (size >= capacity) {
            resize();
        }

        // Insert the root element
        if (size == 0 && !isRootInserted) {
            heap[size] = element;
            isRootInserted = true;
            size++;
            return;
        }

        // Insert the new element at the end of the heap
        heap[size] = element;
        int currentPos = size;
        size++;

        // Heapify up: move the new element to its correct position
        while (currentPos > 0 && heap[currentPos] < heap[parent(currentPos)]) {
            swap(currentPos, parent(currentPos));
            currentPos = parent(currentPos);
        }
    }

    /**
     * Returns the position of the parent of the node at pos.
     * @param pos the position of the node
     * @return the position of the parent node
     */
    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    /**
     * Returns the position of the left child of the node at pos.
     * @param pos the position of the node
     * @return the position of the left child node
     */
    private int leftChild(int pos) {
        return (2 * pos) + 1;
    }

    /**
     * Returns the position of the right child of the node at pos.
     * @param pos the position of the node
     * @return the position of the right child node
     */
    private int rightChild(int pos) {
        return (2 * pos) + 2;
    }

    /**
     * Checks if the node at pos is a leaf node.
     * @param pos the position of the node
     * @return true if the node is a leaf, false otherwise
     */
    private boolean isLeaf(int pos) {
        return pos >= (size / 2) && pos <= size;
    }

    /**
     * Main method to test the MinHeap implementation.
     * @param args command line arguments
     */
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

        // Print the heap elements
        for (int i = 0; i < minHeap.size; i++) {
            System.out.print(minHeap.heap[i] + " ");
        }
    }
}
