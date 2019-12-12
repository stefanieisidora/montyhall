package com.dangelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class GameTest {
    private DoorProvider doorProviderMock;

    @BeforeEach
    void setUp() {
        doorProviderMock = Mockito.mock(DoorProvider.class);
    }


    @ParameterizedTest
    @MethodSource("createSwitchingTestData")
    void whenSwitchingDoor(Door chosenDoor, Door winningDoor, Door nextDoor, boolean expectedResult) {
        when(doorProviderMock.getWinningDoor()).thenReturn(winningDoor);
        when(doorProviderMock.switchDoor(any(), any())).thenReturn(nextDoor);

        var game = new Game(chosenDoor, true, doorProviderMock);
        boolean wonOrNot = game.run();
        assertThat(wonOrNot).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @MethodSource("createNotSwitchingTestData")
    void whenNotSwitchingDoor(Door chosenDoor, Door winningDoor, boolean expectedResult) {
        when(doorProviderMock.getWinningDoor()).thenReturn(winningDoor);

        var game = new Game(chosenDoor, false, doorProviderMock);
        boolean wonOrNot = game.run();
        assertThat(wonOrNot).isEqualTo(expectedResult);
    }


    private static Stream<Arguments> createSwitchingTestData() {
        return Stream.of(
                Arguments.of(new Door("A"), new Door("A"), new Door("B"), false),
                Arguments.of(new Door("A"), new Door("B"), new Door("B"), true),
                Arguments.of(new Door("A"), new Door("B"), new Door("C"), false)
        );
    }

    private static Stream<Arguments> createNotSwitchingTestData() {
        return Stream.of(
                Arguments.of(new Door("A"), new Door("A"), true),
                Arguments.of(new Door("A"), new Door("B"), false)
        );
    }

}