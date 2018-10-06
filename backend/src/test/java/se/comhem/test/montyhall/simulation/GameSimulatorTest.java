package se.comhem.test.montyhall.simulation;

import org.junit.Test;
import se.comhem.test.montyhall.domain.Door;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class GameSimulatorTest {


    @Test
    public void playerDoNotChangeDoor(){
        GameSimulator gameSimulator = new GameSimulator(new Player(false));

        gameSimulator.startSimulation(10000);

        System.out.println(gameSimulator.getWinPercentage());
    }

    @Test
    public void playerDoChangesDoor(){
        GameSimulator gameSimulator = new GameSimulator(new Player(true));

        gameSimulator.startSimulation(10000);

        System.out.println(gameSimulator.getWinPercentage());
    }

    @Test
    public void playerShouldChooseDoor(){
        Player player = new Player(false);
        GameSimulator gameSimulator = new GameSimulator(player);
        Collection<Door> doors = gameSimulator.getDoors();
        player.chooseRandomDoor(doors);
        assertThat(player.getChoosenDoor()).isNotNull();
    }

    @Test
    public void handlerShouldOpenGoatDoor(){
        Player player = new Player(false);
        GameSimulator gameSimulator = new GameSimulator(player);
        int carDoor = 1;
        Handler handler = new Handler(carDoor);
        Collection<Door> doors = gameSimulator.getDoors();
        player.chooseRandomDoor(doors);
        handler.openGoatDoor(doors, player);
        assertThat(doors.stream()
                .filter(door -> door.getDoorNumber() != carDoor)
                .filter(door -> door.getDoorNumber() != player.getChoosenDoor().getDoorNumber())
                .anyMatch(door -> door.isOpen())).isTrue();
    }

    @Test
    public void playerShouldChangeDoor(){
        Player player = new Player(true);
        GameSimulator gameSimulator = new GameSimulator(player);
        Collection<Door> doors = gameSimulator.getDoors();
        player.chooseRandomDoor(doors);
        Door choosenDoor = player.getChoosenDoor();
        player.chooseToChangeDoor(doors);
        Door changedChoosenDoor = player.getChoosenDoor();
        assertThat(choosenDoor.getDoorNumber()).isNotEqualTo(changedChoosenDoor.getDoorNumber());
    }

    @Test
    public void playerShouldNotChangeDoor(){
        Player player = new Player(false);
        GameSimulator gameSimulator = new GameSimulator(player);
        Collection<Door> doors = gameSimulator.getDoors();
        player.chooseRandomDoor(doors);
        Door choosenDoor = player.getChoosenDoor();
        player.chooseToChangeDoor(doors);
        Door changedChoosenDoor = player.getChoosenDoor();
        assertThat(choosenDoor.getDoorNumber()).isEqualTo(changedChoosenDoor.getDoorNumber());
    }
}