package se.comhem.test.montyhall.domain;

import lombok.Data;

@Data
public class SimulationRequest {

    private long numberOfSimulations;
    private boolean changeDoor;
}
