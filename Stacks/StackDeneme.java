package com.mert.Stacks;

public class StackDeneme {
    int[] stack;
    int top = 0;
    int size = 8;

    public StackDeneme() {
        stack = new int[size];
    }

    void push(int value) {
        if (top == size) {
            System.out.println("stack is full");
            return;
        }

        stack[top++] = value;
    }

    int pop() {
        if (top == 0) {
            System.out.println("Stack is empty!");
            return 0;
        }
        return stack[top--];
    }

    void print() {
        for (int i = 0; i < top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.print("top : " + top);
    }

    public static void main(String[] args) {
        StackDeneme stack = new StackDeneme();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.print();
        stack.pop();
        stack.print();
    }

}
