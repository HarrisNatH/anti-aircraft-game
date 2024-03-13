# Anti Aircraft Program

## Description
This is a past exercise during university, a game where a player guess the coordinates to bring down the target.

## Game Criteria 
 Create an enumerated type Result in its own file. The enum must have 8 possible values: HIT, FAIL LEFT,
 FAIL RIGHT, FAIL HIGH, FAIL LOW, FAIL SHORT, FAIL LONG, OUT OF RANGE. Hint: the enum must be
 public.

 Then create a Java class Target with the following methods:

    • A constructor method Target(int) that creates a 3-D array of integers of the proposed size in all three
    dimensions. All elements must be set to zero.
 
    • A method called init() that sets all the elements in the matrix to 0 except one —selected randomly— that
    will be set to 1. Hint: Remember that you can get a random integer between 0 and N (not including N) by
    using int numberToGuess = (int) Math.abs(N * Math.random()).
 
    • fire(int,int,int) a method that checks whether the element determined by the indexes is 1 and returns
    a type Result according to the result: Result.HIT if the element is 1, Result. FAIL_LEFT if the element of
    value one is “to the left” (you must decide what left and right are in your 3-D array), etc. If any of the
    indices is too big (or negative), the method must return Result.OUT_OF_RANGE. Left–right information takes
    precedence over high–low, and this takes precendence over short–long. If the 1 is to the left and behind, the
    output should be Result.FAIL_LEFT.

## Console example
    Here they come! Try to bring the plane down!
    Enter a coordinate X: 30
    Enter a coordinate Y: 4
    Enter a coordinate Z: 5
    That shot is way out of range. Try harder!
    Enter a coordinate X: 3
    Enter a coordinate Y: 4
    Enter a coordinate Z: 5
    You missed! The target is to the right!
    Enter a coordinate X: 5
    Enter a coordinate Y: 4
    Enter a coordinate Z: 1
    You missed! The target is farther!
    Enter a coordinate X: 5
    Enter a coordinate Y: 4
    Enter a coordinate Z: 5
    You hit it! Well done!
    Would you like to play again? y
    Here they come! Try to bring the plane down!
    Enter a coordinate X:

## Running the binary
Simply press run the program.

## Code details
The game will begin by asking player to input a number to initialises 3D array with a random target at certain position unknown to player. Afterwards, player will be required to issue a coordinate command for all 3 axis.

The command will return either a HIT / OUT_OF_RANGE / FAIL. As long as a target hasn't been hit, player will be looped back to fire command.

The game ends when the target is hit, and prompts player to play again or end.

Thank you for reading and happy shooting!

## LICENSE
This project has a MIT license.