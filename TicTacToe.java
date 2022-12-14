package cmsc256;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create the board and set all positions to empty
        String[][] board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = " ";
            }
        }

        // Print the initial board
        printBoard(board);

        // Set the current player to X
        String currentPlayer = "X";

        // Keep playing until the game is over
        while (true) {
            // Get the player's move
            System.out.print("Player " + currentPlayer + ", enter the row and column of your move: ");
            int row = input.nextInt();
            int col = input.nextInt();

            // Make sure the move is valid
            if (row < 0 || row > 2 || col < 0 || col > 2 || !board[row][col].equals(" ")) {
                System.out.println("Invalid move. Please try again.");
                continue;
            }

            // Place the player's move on the board
            board[row][col] = currentPlayer;

            // Print the updated board
            printBoard(board);

            // Check if the game is over
            if (isGameOver(board)) {
                System.out.println("Game over!");
                break;
            }

            // Switch to the other player
            if (currentPlayer.equals("X")) {
                currentPlayer = "O";
            } else {
                currentPlayer = "X";
            }
        }
    }

    // Print the current state of the board
    public static void printBoard(String[][] board) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    // Check if the game is over
    public static boolean isGameOver(String[][] board) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (!board[i][0].equals(" ") && board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (!board[0][i].equals(" ") && board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i])) {
                return true;
            }
        }

        // Check diagonals
        if (!board[0][0].equals(" ") && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
            return true;
        }
        if (!board[0][2].equals(" ") && board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])) {
            return true;
        }
        // Check if there are any empty spaces on the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }

        // If no empty spaces and no winners, it's a draw
        System.out.println("It's a draw!");
        return true;
    }
}