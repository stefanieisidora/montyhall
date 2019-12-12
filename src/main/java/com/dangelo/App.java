package com.dangelo;

import java.util.stream.IntStream;

public class App {

    public static final int NUMBER_OF_GAMES = 1000;

    public static void main(String[] args) {
        System.out.println("The game will run 1000 times, a box will be randomly chosen");
        var doorProvider = new DoorProvider();
        var chosenDoor = doorProvider.getRandomDoor();
        System.out.println("Door " + chosenDoor + " was chosen");

        System.out.println("The result if you chose to switch door:");
        playMontyHall(true, doorProvider, chosenDoor);

        System.out.println("The result if you chose to not switch door:");
        playMontyHall(false, doorProvider, chosenDoor);
    }

    private static void playMontyHall(
            boolean switchDoors,
            DoorProvider doorProvider,
            Door chosenDoor) {
        var game = new Game(chosenDoor, switchDoors, doorProvider);
        var successResults = IntStream.rangeClosed(1, NUMBER_OF_GAMES)
                .mapToObj(i -> game.run())
                .filter(result -> result == true)
                .count();
        System.out.println("Number of success results: " + successResults);
        var successRate = (float)successResults / NUMBER_OF_GAMES * 100;
        System.out.println("Success rate: " + String.format("%.02f", successRate) + "%" );
    }
}
