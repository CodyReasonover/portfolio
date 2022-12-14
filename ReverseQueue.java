package cmsc256;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseQueue {
    public static void main(String[] args) {
        // Create a new queue
        Deque<String> queue = new ArrayDeque<>();

        // Add elements to the queue
        queue.add("alpha");
        queue.add("beta");
        queue.add("iota");
        queue.add("theta");
        queue.add("epsilon");
        queue.add("psi");

        System.out.println("Current queue:" +queue);
        // Create a new stack
        ArrayDeque<String> stack = new ArrayDeque<>();

        // Dequeue elements from the queue and push them onto the stack
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        System.out.println("Current queue after first loop:" +queue);
        // Pop elements from the stack and enqueue them onto the queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        // Print the final state of the queue
        System.out.println("Final queue: " + queue);
    }
}

