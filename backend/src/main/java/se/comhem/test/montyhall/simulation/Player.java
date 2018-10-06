package se.comhem.test.montyhall.simulation;

import lombok.Getter;
import lombok.Setter;
import se.comhem.test.montyhall.domain.Door;

import java.util.Collection;
import java.util.Random;


public class Player {

    @Getter
    private boolean changeDoor;

    @Getter
    @Setter
    private Door choosenDoor;

    private Random rand = new Random();

    public Player(boolean changeDoor){
        this.changeDoor = changeDoor;
    }

    public void chooseRandomDoor(Collection<Door> doors){
        int playerChoosenDoor = rand.nextInt(3);
        Door choosenDoor = doors.stream().filter(door -> door.getDoorNumber() == playerChoosenDoor)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No doors to choose"));

        this.choosenDoor = choosenDoor;
    }

    public void chooseToChangeDoor(Collection<Door> doors){
        if(isChangeDoor()) {
            Door newChoosenDoor = doors.stream().filter(door -> !door.isOpen() && choosenDoor.getDoorNumber() != door.getDoorNumber())
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("No doors to choose"));
            this.choosenDoor = newChoosenDoor;
        }
    }

}
