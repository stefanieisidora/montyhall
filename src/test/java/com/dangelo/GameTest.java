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
    void whenSwitchingDoor(String choosenDoor, String winningDoor, String nextDoor, boolean expectedResult) {
        when(doorProviderMock.getWinningDoor()).thenReturn(winningDoor);
        when(doorProviderMock.switchDoor(any())).thenReturn(nextDoor);

        var game = new Game(choosenDoor, true, doorProviderMock);
        boolean wonOrNot = game.run();
        assertThat(wonOrNot).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @MethodSource("createNotSwitchingTestData")
    void whenNotSwitchingDoor(String choosenDoor, String winningDoor, boolean expectedResult) {
        when(doorProviderMock.getWinningDoor()).thenReturn(winningDoor);

        var game = new Game(choosenDoor, false, doorProviderMock);
        boolean wonOrNot = game.run();
        assertThat(wonOrNot).isEqualTo(expectedResult);
    }


    private static Stream<Arguments> createSwitchingTestData() {
        return Stream.of(
                Arguments.of("A", "A", "B", false),
                Arguments.of("A", "B", "B", true),
                Arguments.of("A", "B", "C", false)
        );
    }

    private static Stream<Arguments> createNotSwitchingTestData() {
        return Stream.of(
                Arguments.of("A", "A", true),
                Arguments.of("A", "B", false)
        );
    }

}