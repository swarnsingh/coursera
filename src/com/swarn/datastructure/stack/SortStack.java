package com.swarn.datastructure.stack;

import java.util.Stack;

/**
 * @author Swarn Singh.
 */
public class SortStack {

    public static Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> tmpStack = new Stack();
        while (!input.isEmpty()) {
            // pop out the first element
            int tmp = input.pop();

            // while temporary stack is not empty and
            // top of stack is greater than temp
            while (!tmpStack.isEmpty() && tmpStack.peek() > tmp) {
                // pop from temporary stack and
                // push it to the input stack
                input.push(tmpStack.pop());
            }
            // push temp in tempory of stack
            tmpStack.push(tmp);
        }
        return tmpStack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(34);
        stack.add(3);
        stack.add(31);
        stack.add(98);
        stack.add(92);
        stack.add(23);

        // This is the temporary stack
        stack = sortStack(stack);
        System.out.println("Sorted numbers are:");

        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
