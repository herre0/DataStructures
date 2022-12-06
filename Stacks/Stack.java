package com.mert.Stacks;

public class Stack {
    int[] stack;
    int top = 0;
    int size = 2;

    public Stack() {
        stack = new int[size];
    }

    int pop() {
        if (top - 1 <= size / 4) {
            int[] newArr = new int[size / 2];
            for (int i = 0; i < top; i++) {
                newArr[i] = stack[i];
            }
            stack = newArr;
            size /= 2;
        }

        return stack[--top];
    }

    void push(int value) {
        if (top >= size) {
            int[] newArr = new int[size * 2];
            for (int i = 0; i < top; i++) {
                newArr[i] = stack[i];
            }
            stack = newArr;
            size *= 2;
        }

        stack[top++] = value;
    }

    void print() {
        System.out.print("\n");
        for (int i = 0; i < top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.print(" size : " + size);
        System.out.print(" top : " + top);
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.print();
        System.out.print("\npopped: " + stack.pop());
        System.out.print("\npopped: " + stack.pop());
        System.out.print("\npopped: " + stack.pop());
        stack.print();
    }

    // some methods may be written
    // peek() : returns the last element in the stack
    // isEmpty()

}
