package cmsc256;

import java.util.Scanner;

public class RecursionString {
    public static void main(String[] args) {
// Create a new Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");

        // Read the user's input and store it in a variable
        String input = scanner.nextLine();

        // Call the count11() function with the user's input as an argument
        int count = count11(input);

        // Print the number of occurrences of the substring "11" in the string
        System.out.println("The number of occurrences of the substring '11' in the string is: " + count);
    }

    public static int count11(String str) {
        // If the length of the string is less than 2, return 0,
        // because there cannot be any occurrences of the substring "11" in a string with fewer than 2 characters
        if (str.length() < 2) {
            return 0;
        }

        // Check if the first two characters of the string are "11"
        if (str.substring(0, 2).equals("11")) {
            // If they are, increment the counter and remove the substring from the string
            // Then call the count11() function again with the remaining part of the string as an argument
            return 1 + count11(str.substring(2));
        } else {
            // If the first two characters are not "11", remove the first character and continue searching
            // To do this, call the count11() function again with the remaining part of the string as an argument
            return count11(str.substring(1));
        }
    }
}
