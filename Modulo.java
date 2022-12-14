package cmsc256;

import java.util.Scanner;

public class Modulo {
    public static void main(String[] args) {
        // Create a Scanner to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the divisor and dividend
        System.out.print("Enter the dividend: ");
        int dividend = scanner.nextInt();
        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        // Calculate the modulo of the dividend and divisor
        int modulo = dividend % divisor;

        // Print the result
        System.out.println("The modulo is: " + modulo);
    }
}
