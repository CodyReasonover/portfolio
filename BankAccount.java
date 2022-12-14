import java.util.Scanner;

public class BankAccount {
    private double balance; // The current balance of the bank account
    public BankAccount() {
        this.balance = 0.0; // Initialize the balance to 0.0
    }

    public void deposit(double amount) {
        this.balance += amount; // Add the amount to the current balance
    }

    public void withdraw(double amount) {
        if (amount > this.balance) { // If the withdrawal amount is more than the balance
            System.out.println("Insufficient funds"); // Print a message indicating insufficient funds
        } else {
            this.balance -= amount; // Otherwise, subtract the withdrawal amount from the balance
        }
    }

    public double getBalance() {
        return this.balance; // Return the current balance
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BankAccount account = new BankAccount();

        System.out.println("How much money is currently in your bank account?");
        account.balance = input.nextDouble(); // Get the initial balance from the user

        System.out.println("How much would you like to withdraw?");
        double amount = input.nextDouble(); // Get the withdrawal amount from the user

        if (amount > 0) { // If the withdrawal amount is positive
            account.withdraw(amount); // Withdraw the amount from the account
            System.out.println("Your new balance is: " + account.getBalance()); // Print the new balance
        } else if (amount < 0) { // If the withdrawal amount is negative
            System.out.println("Please enter a positive amount to withdraw."); // Print an error message
        } else { // If the withdrawal amount is 0
            System.out.println("Your balance remains the same: " + account.getBalance()); // Print the current balance
        }

        System.out.println("How much would you like to deposit?");
        amount = input.nextDouble(); // Get the deposit amount from the user

        if (amount > 0) { // If the deposit amount is positive
            account.deposit(amount); // Deposit the amount in the account
            System.out.println("Your new balance is: " + account.getBalance()); // Print the new balance
        } else if (amount < 0) { // If the deposit amount is negative
            System.out.println("Please enter a positive amount to deposit."); // Print an error message
        } else { // If the deposit amount is 0
            System.out.println("Your balance remains the same: " + account.getBalance()); // Print the current balance
        }
    }
}




