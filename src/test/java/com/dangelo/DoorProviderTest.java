package com.dangelo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DoorProviderTest {

    @Test
    void whenChosenDoorIsNotWinningDoorThenSwitchedDoorShouldBeTheWinning() {
        var doorProvider = new DoorProvider();
        var switchedDoor = doorProvider.switchDoor(new Door("A"), new Door("B"));
        assertThat(switchedDoor.getId()).isEqualTo("B");
    }
}