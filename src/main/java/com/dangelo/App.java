package com.dangelo;

import java.util.stream.IntStream;

public class App {

    private static final int NUMBER_OF_GAMES = 1000;

    public static void main(String[] args) {
        System.out.println("The game will run 1000 times, a door will be randomly chosen");
        var doorProvider = new DoorProvider();
        var chosenDoor = doorProvider.getRandomDoor();
        System.out.println("Door " + chosenDoor + " was chosen");

        System.out.println("Result of simulation where you choose to always switch door:");
        playMontyHall(true, doorProvider, chosenDoor);

        System.out.println("Result of simulation where you choose to never switch door:");
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
