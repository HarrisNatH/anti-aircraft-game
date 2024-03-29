package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain = "y";
        while(playAgain.equalsIgnoreCase("y")) {
            //asks player to input a number to create a 3D map
            System.out.print("Please enter a number to init 3D map: ");
            int size = scanner.nextInt();
            Target target = new Target(size);
            target.init();
            //game start
            int range = size-1;
            System.out.println("Here they come! Try to bring the plane down! (input between 0 to " + range + ")");
            while (true) {
                System.out.print("Enter a coordinate X: ");
                int x = scanner.nextInt();
                System.out.print("Enter a coordinate Y: ");
                int y = scanner.nextInt();
                System.out.print("Enter a coordinate Z: ");
                int z = scanner.nextInt();

                Result result = target.fire(x, y, z);
                switch (result) {
                    case HIT:
                        System.out.println("You hit it! Well done!\n");
                        break;
                    case OUT_OF_RANGE:
                        System.out.println("That shot is way out of range. Try harder!\n");
                        break;
                    default:
                        System.out.println("You missed! The target is to the " + result.name().replace("FAIL_", "") + "!\n");
                        break;
                }

                if (result == Result.HIT) {
                    break;
                }
            }
            System.out.print("Would you like to play again? y/n: ");
            playAgain = scanner.next();
        }
        scanner.close();
    }
}
