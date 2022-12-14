package cmsc256;

import java.util.Stack;

public class QueueCon {
    public static void main(String[] args) {
        int num = 85;
        int result = 1;

        // Create a new empty stack of integers
        Stack<Integer> myStack = new Stack<Integer>();

        // Loop until num is greater than or equal to 100
        // 85 is less than 100
        while(num < 100) {
            // Push the current value of num onto the stack
            // Add the current value of num onto the stack
            myStack.push(num);
            // Add 5 to the value of num
            // Goes to 80 + 5 = 85
            // 85 + 5 = 90
            // 90 + 5 = 95
            num+= 5;

            // Now this part of the code is done since 100 is equal to 100, so stop at 95
        }

        // Loop until the stack is empty
        while (!myStack.isEmpty()) {
            // Remove the top element of the stack and assign it to the value variable
            // Remove top of stack
            Integer value = myStack.pop();
            // Add the value of value to the result
            // 85 + 90 + 95
            result = result + value;
        }

        // Print the final value of result to the console
        System.out.println(result);
    }
}

// Goes to 85 -> 90 -> 95 -> 100(100 would not count because it cannot be equal to 100)
// 3 iterations which makes i

