package com.mert.Queues;

public class Queue {
    int[] queue;
    int front = 0;
    int rear = 0;
    int size = 2;

    public Queue() {
        queue = new int[size];
    }

    void reset() {
        if(front == 0)
            return;

        if(rear-front <= size/4){
            int[] newArr = new int[size/2];
            for(int i = 0; i < rear-front; i++)
                newArr[i] = queue[i];

            queue = newArr;
            rear -= front;
            front = 0;
            size /= 2;
        }
    }

    int deque() {
        reset();

        return queue[front++];
    }

    void enque(int value) {
        if(rear + 1 >= size) {
            int[] newArr = new int[size * 2];
            for(int i = 0; i < rear-front; i++)
                newArr[i] = queue[i];

            queue = newArr;
            size *= 2;
        }
        queue[rear++] = value;
    }

    void print() {
        System.out.print("\n");
        for(int i = 0; i < size; i++){
            if(i < front)
                System.out.print("0 ");// bu gosterim keyfe keder
            else
                System.out.print(queue[i] + " ");
        }
        System.out.println("size: " + size + " front: " + front + " rear: " + rear);
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enque(10);
        queue.enque(20);
        queue.enque(30);
        queue.enque(40);
        queue.print();
        queue.deque();
        queue.deque();
        queue.deque();
        queue.print();
    }

}
