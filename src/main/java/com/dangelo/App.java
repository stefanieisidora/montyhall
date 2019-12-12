package com.dangelo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App 
{
    public static void main( String[] args )
    {
        var numberOfGames = 100;
        var switchDoors = true;
        var doorProvider = new DoorProvider();
        var choosenDoor = "A";
        var game = new Game(choosenDoor, switchDoors, doorProvider);
        var successResults = IntStream.rangeClosed(1, numberOfGames).mapToObj(i -> game.run()).filter(result -> result == true).count();
        System.out.println("Number of success results: "+successResults);
        var successRate = numberOfGames / successResults;
        System.out.println("Success rate: "+ String.format("%.2g%n",successRate));
    }
}
