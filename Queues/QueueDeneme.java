package com.mert.Queues;

public class QueueDeneme {
    int[] queue;
    int front = 0;
    int rear = 0;
    int capacity = 2;

    public QueueDeneme() {
        queue = new int[capacity];
    }

    void enque(int value) {
        if (rear >= capacity) {
            int[] newArr = new int[capacity * 2];
            for (int i = front; i < rear; i++) {
                newArr[i] = queue[i];
            }
            queue = newArr;
            capacity *= 2;
        }

        queue[rear++] = value;
    }

    int deque() {
        if (rear - front - 1 <= capacity / 4) {
            int[] newArr = new int[capacity / 2];
            for (int i = front, j = 0; i < rear; i++, j++) {
                newArr[j] = queue[i];
            }
            queue = newArr;
            capacity /= 2;
            rear -= front;
            front = 0;
        }

       return queue[front++];
    }

    void print() {
        for(int i = front; i < rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println("capacity: " + capacity + " front: " + front + " rear: " + rear);
    }

    public static void main(String[] args) {
        QueueDeneme queue = new QueueDeneme();
        queue.enque(1);
        queue.enque(2);
        queue.enque(3);
        queue.enque(4);
        queue.enque(5);
        queue.print();
        queue.deque();
        queue.deque();
        queue.deque();
        queue.print();

    }

}
