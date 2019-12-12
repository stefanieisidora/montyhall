package com.dangelo;

public class Game {
    private String chosenDoor;
    private boolean switchDoors;
    private DoorProvider doorProvider;

    public Game(String chosenDoor, boolean switchDoors, DoorProvider doorProvider) {
        this.chosenDoor = chosenDoor;
        this.switchDoors = switchDoors;
        this.doorProvider = doorProvider;
    }

    public boolean run() {
        var winningDoor = doorProvider.getWinningDoor();
        if (switchDoors) {
            this.chosenDoor = doorProvider.switchDoor(chosenDoor);
        }

        return winningDoor.equals(chosenDoor);
    }


}
