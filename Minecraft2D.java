package cmsc256;

import java.util.Arrays;
import java.util.Scanner;

public class Minecraft2D {

    // Define the size of the game world
    public static final int WORLD_WIDTH = 10;
    public static final int WORLD_HEIGHT = 10;

    // Define some materials that can be placed in the world
    public static final int AIR = 0;
    public static final int DIRT = 1;
    public static final int STONE = 2;
    public static final int COAL = 3;
    public static final int WOOD = 4;
    public static final int LEAVES = 5;

    // Define a 2D array to represent the game world
    public int[][] world = new int[WORLD_WIDTH][WORLD_HEIGHT];

    // Define the player's position and inventory
    public int playerX = 0;
    public int playerY = 0;
    public int[] inventory = new int[6];

    public Minecraft2D() {
        // Initialize the game world with a mixture of air, dirt, and stone blocks
        for (int x = 0; x < WORLD_WIDTH; x++) {
            for (int y = 0; y < WORLD_HEIGHT; y++) {
                if (y == 0) {
                    world[x][y] = STONE;
                } else if (y == 1) {
                    world[x][y] = DIRT;
                } else {
                    world[x][y] = AIR;
                }
            }
        }

        // Initialize the player's inventory with some starting items
        inventory[STONE] = 10;
        inventory[COAL] = 5;
        inventory[WOOD] = 5;
    }

    public void setBlock(int x, int y, int material) {
        // Check that the coordinates are within the bounds of the world
        if (x >= 0 && x < WORLD_WIDTH && y >= 0 && y < WORLD_HEIGHT) {
            world[x][y] = material;
        }
    }

    public int getBlock(int x, int y) {
        // Check that the coordinates are within the bounds of the world
        if (x >= 0 && x < WORLD_WIDTH && y >= 0 && y < WORLD_HEIGHT) {
            return world[x][y];
        }
        return AIR;
    }

    public void movePlayer(int dx, int dy) {
        // Calculate the new position of the player
        int newX = playerX + dx;
        int newY = playerY + dy;

        // Check if the new position is within the bounds of the world
        if (newX >= 0 && newX < WORLD_WIDTH && newY >= 0 && newY < WORLD_HEIGHT) {
            playerX = newX;
            playerY = newY;
        }
    }

    public void mineBlock() {
        // Get the material of the block that the player is standing on
        int material = getBlock(playerX, playerY);

        // If the player is standing on a block that can be mined, add it to their inventory
        if (material == STONE || material == COAL || material == WOOD) {
            inventory[material]++;
        }
    }

    public void craft() {
        // Check if the player has enough materials to craft a new item
        if (inventory[STONE] >= 2 && inventory[COAL] >= 1) {
            // Remove the necessary materials from the player's inventory
            inventory[STONE] -= 2;
            inventory[COAL] -= 1;

            // Add the new item to the player's inventory
            inventory[WOOD]++;
        }
    }

    public void placeBlock(int material) {
        // Check if the player has the necessary materials to place the block
        if (inventory[material] > 0) {
            // Remove the necessary materials from the player's inventory
            inventory[material]--;

            // Place the block in the game world
            setBlock(playerX, playerY, material);
        }
    }

    public static void main(String[] args) {
        Minecraft2D game = new Minecraft2D();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Print the game world
            for (int y = 0; y < WORLD_HEIGHT; y++) {
                for (int x = 0; x < WORLD_WIDTH; x++) {
                    if (x == game.playerX && y == game.playerY) {
                        System.out.print("P");
                    } else {
                        System.out.print(game.getBlock(x, y));
                    }
                }
                System.out.println();
            }

            // Print the player's inventory
            System.out.println("Inventory: " + Arrays.toString(game.inventory));

            // Print a prompt for the player's next action
            System.out.print("> ");
            String action = scanner.nextLine();

            // Parse the player's action and update the game state accordingly
            if (action.equals("w")) {
                game.movePlayer(0, -1);
            } else if (action.equals("a")) {
                game.movePlayer(-1, 0);
            } else if (action.equals("s")) {
                game.movePlayer(0, 1);
            } else if (action.equals("d")) {
                game.movePlayer(1, 0);
            } else if (action.equals("m")) {
                game.mineBlock();
            } else if (action.equals("c")) {
                game.craft();
            } else if (action.startsWith("p")) {
                try {
                    int material = Integer.parseInt(action.substring(1));
                    game.placeBlock(material);
                } catch (Exception e) {
                    // Print an error message if the player's action is invalid
                    System.out.println("Invalid action: " + action);
                }
            }
        }
    }
}

