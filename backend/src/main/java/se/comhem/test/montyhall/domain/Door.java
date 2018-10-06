package se.comhem.test.montyhall.domain;

import lombok.Getter;
import lombok.Setter;


public class Door {

    @Getter
    private int doorNumber;

    @Getter
    @Setter
    private boolean open;

    public Door(int doorNumber){
        this.doorNumber = doorNumber;
    }

}
