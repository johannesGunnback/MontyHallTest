package se.comhem.test.montyhall.simulation;

import lombok.AllArgsConstructor;
import se.comhem.test.montyhall.domain.Door;

import java.util.Collection;

@AllArgsConstructor
public class Handler {

    private int carDoorNumber;

    public void openGoatDoor(Collection<Door> doors, Player player) {
        doors.stream()
                .filter(door -> door.getDoorNumber() != player.getChoosenDoor().getDoorNumber()
                        && door.getDoorNumber() != carDoorNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No doors to open you cheated!"))
                .setOpen(true);
    }

    public boolean isWinner(Door choosenDoor) {
        return choosenDoor.getDoorNumber() == carDoorNumber;
    }
}
