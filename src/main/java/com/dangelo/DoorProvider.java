package com.dangelo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class DoorProvider {
    private Random random;
    public static final int NUMBER_OF_DOORS = 3;
    public static final List<String> ALL_DOORS = Arrays.asList("A", "B", "C");

    public DoorProvider() {
        this.random = new Random();
    }
    public String getWinningDoor(){
        return ALL_DOORS.get(random.nextInt(NUMBER_OF_DOORS));
    }

    public String switchDoor(String choosenDoor) {
        var remainingDoors = ALL_DOORS
                .stream()
                .filter(door -> !door.equals(choosenDoor))
                .collect(Collectors.toList());
        return remainingDoors.get(random.nextInt(NUMBER_OF_DOORS - 1));
    }
}
