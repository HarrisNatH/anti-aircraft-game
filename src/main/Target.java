package main;

import java.util.Random;

public class Target {
    private int[][][] grid;
    private int targetX, targetY, targetZ;

    public Target(int size) {
        grid = new int[size][size][size];
    }

    /**
     * A method to create a 3D array and assign a random target in it 
     */
    public void init() {
        //create a random target at designated place
        Random rand = new Random();
        targetX = rand.nextInt(grid.length);
        targetY = rand.nextInt(grid[0].length);
        targetZ = rand.nextInt(grid[0][0].length);
        
        //create an empty 3D array
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                for (int z = 0; z < grid[x][y].length; z++) {
                    grid[x][y][z] = 0;
                }
            }
        }
        //assigning a target in the 3D array
        grid[targetX][targetY][targetZ] = 1;
    }

    /**
     * A method to issue command, using if else statement and enum
     * @param x horizontal axis
     * @param y vertical axis
     * @param z long axis
     * @return OUT_OF_RANGE if the issued command is outside of the 3D map
     * @return HIT if the issued command hits a target
     * @return FAIL if the issued command misses a target
     */
    public Result fire(int x, int y, int z) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || z < 0 || z >= grid[0][0].length) {
            return Result.OUT_OF_RANGE;
        } else if (grid[x][y][z] == 1) {
            return Result.HIT;
        } else {
            if (x < targetX) return Result.FAIL_RIGHT;
            else if (x > targetX) return Result.FAIL_LEFT;
            else if (y < targetY) return Result.FAIL_HIGH;
            else if (y > targetY) return Result.FAIL_LOW;
            else if (z < targetZ) return Result.FAIL_FAR;
            else return Result.FAIL_NEAR;
        }
    }
}

