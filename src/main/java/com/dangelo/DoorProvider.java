package com.dangelo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
                .stream()
                .collect(Collectors.toList())
                .get(random.nextInt(NUMBER_OF_DOORS));
    }

    public Door switchDoor(Door chosenDoor, Door winningDoor) {
        var openedDoor = openDoor(chosenDoor, winningDoor);
        var remainingDoor = allDoors
                .stream()
                .filter(door -> !door.getId().equals(chosenDoor.getId())
                        && !door.getId().equals(openedDoor.getId()) )
                .collect(Collectors.toList()).get(0);
        return remainingDoor;
    }

    private Door openDoor(Door chosenDoor, Door winningDoor) {
        return allDoors
                .stream()
                .filter(door -> !door.getId().equals(chosenDoor.getId()) && !door.getId().equals(winningDoor.getId()))
                .findAny()
                .get();
    }

    public Door getRandomDoor() {
        return allDoors.stream()
                .collect(Collectors.toList())
                .get(random.nextInt(NUMBER_OF_DOORS));
    }
}
