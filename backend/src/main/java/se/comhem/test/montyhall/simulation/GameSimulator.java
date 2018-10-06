package se.comhem.test.montyhall.simulation;

import lombok.Getter;
import se.comhem.test.montyhall.domain.Door;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class GameSimulator {

    @Getter
    private BigDecimal winPercentage;
    private Player player;
    private Random rand = new Random();

    public GameSimulator(Player player){
        this.player = player;
    }

    public void startSimulation(long simulationRuns) {
        long runCounter = 0, winCounter = 0;
        while (runCounter < simulationRuns) {
            boolean winner = playRound(player);
            if(winner) {
                winCounter++;
            }
            runCounter++;
        }
        this.winPercentage =  BigDecimal.valueOf(winCounter)
                .divide(BigDecimal.valueOf(simulationRuns))
                .multiply(BigDecimal.valueOf(100L));
    }

    private boolean playRound(Player player) {
        int carDoorNumber = rand.nextInt(3);
        Handler handler = new Handler(carDoorNumber);
        Collection<Door> doors = getDoors();

        player.chooseRandomDoor(doors);
        handler.openGoatDoor(doors, player);
        player.chooseToChangeDoor(doors);

        return handler.isWinner(player.getChoosenDoor());
    }

    Collection<Door> getDoors() {
        List<Door> doors = new ArrayList<>();
        doors.add(new Door(0));
        doors.add(new Door(1));
        doors.add(new Door(2));
        return doors;
    }

}
