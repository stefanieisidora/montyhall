package com.dangelo;

public class Game {
    private Door chosenDoor;
    private boolean switchDoors;
    private DoorProvider doorProvider;

    public Game(Door chosenDoor, boolean switchDoors, DoorProvider doorProvider) {
        this.chosenDoor = chosenDoor;
        this.switchDoors = switchDoors;
        this.doorProvider = doorProvider;
    }

    public boolean run() {
        var winningDoor = doorProvider.getWinningDoor();
        if (switchDoors) {
            this.chosenDoor = doorProvider.switchDoor(chosenDoor, winningDoor);
        }

        return winningDoor.getId().equals(chosenDoor.getId());
    }


}
