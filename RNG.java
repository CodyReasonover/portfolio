package cmsc256;

import java.util.Random;

public class RNG {
    public static void main(String[] args) {
        // This line creates a new Random object, which we will use to generate our random number.
        // The Random class provides a method called nextInt() that generates a random integer (a whole number).
        // We will use this method to generate our random number.
        Random random = new Random();

        // This line generates the random number using the nextInt() method of the Random object we created earlier.
        // The nextInt() method takes an integer parameter that specifies the maximum value of the random number to be generated.
        // In this case, we pass it the value 100, which means the method will generate a random number between 0 and 99.
        // Since we want the number to be between 1 and 100, we add 1 to the result.
        // The result is assigned to the randomNumber variable, which is an int (integer) type.
        int randomNumber = random.nextInt(100) + 1;

        // Print the random number
        System.out.println(randomNumber);
    }
}
