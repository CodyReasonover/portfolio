package cmsc256;

import java.util.Scanner;

public class BankAccount {
    private double balance;
    public BankAccount() {
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > this.balance) {
            System.out.println("Insufficient funds");
        } else {
            this.balance -= amount;
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BankAccount account = new BankAccount();

        System.out.println("How much money is currently in your bank account?");
        account.balance = input.nextDouble();

        System.out.println("How much would you like to withdraw?");
        double amount = input.nextDouble();

        if (amount > 0) {
            account.withdraw(amount);
            System.out.println("Your new balance is: " + account.getBalance());
        } else if (amount < 0) {
            System.out.println("Please enter a positive amount to withdraw.");
        } else {
            System.out.println("Your balance remains the same: " + account.getBalance());
        }

        System.out.println("How much would you like to deposit?");
        amount = input.nextDouble();

        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Your new balance is: " + account.getBalance());
        } else if (amount < 0) {
            System.out.println("Please enter a positive amount to deposit.");
        } else {
            System.out.println("Your balance remains the same: " + account.getBalance());
        }
    }
}