package com.dangelo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DoorProvider {
    private Random random;
    private static final int NUMBER_OF_DOORS = 3;
    private final List<Door> allDoors = Arrays.asList(
            new Door("A"),
            new Door("B"),
            new Door("C"));

    public DoorProvider() {
        this.random = new Random();
    }
    public Door getWinningDoor(){
        return allDoors
                .get(random.nextInt(NUMBER_OF_DOORS));
    }

    public Door switchDoor(Door chosenDoor, Door winningDoor) {
        var openedDoor = openDoor(chosenDoor, winningDoor);
        return allDoors
                .stream()
                .filter(door -> !door.equals(chosenDoor)
                        && !door.equals(openedDoor) )
                .findAny().get();
    }

    private Door openDoor(Door chosenDoor, Door winningDoor) {
        return allDoors
                .stream()
                .filter(door -> !door.equals(chosenDoor) && !door.equals(winningDoor))
                .findAny()
                .get();
    }

    public Door getRandomDoor() {
        return allDoors.get(random.nextInt(NUMBER_OF_DOORS));
    }
}
