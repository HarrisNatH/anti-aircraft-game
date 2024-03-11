package main;

import java.util.Random;

public class Target {
    private int[][][] grid;
    private int targetX, targetY, targetZ;

    public Target(int size) {
        grid = new int[size][size][size];
    }

    public void init() {
        Random rand = new Random();
        targetX = rand.nextInt(grid.length);
        targetY = rand.nextInt(grid[0].length);
        targetZ = rand.nextInt(grid[0][0].length);
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                for (int z = 0; z < grid[x][y].length; z++) {
                    grid[x][y][z] = 0;
                }
            }
        }
        grid[targetX][targetY][targetZ] = 1;
    }

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

