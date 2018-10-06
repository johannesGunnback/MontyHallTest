package se.comhem.test.montyhall.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.comhem.test.montyhall.simulation.Player;
import se.comhem.test.montyhall.domain.SimulationRequest;
import se.comhem.test.montyhall.domain.SimulationResponse;
import se.comhem.test.montyhall.simulation.GameSimulator;

@RestController
public class MontyHallController {


    @PostMapping("montyhall/simulation")
    public ResponseEntity<SimulationResponse> simulate(@RequestBody SimulationRequest request) {
        if(!isValid(request)){
            return ResponseEntity.badRequest().build();
        }
        Player player = new Player(request.isChangeDoor());
        GameSimulator gameSimulator = new GameSimulator(player);
        gameSimulator.startSimulation(request.getNumberOfSimulations());
        return ResponseEntity.ok(new SimulationResponse(gameSimulator.getWinPercentage()));
    }

    private boolean isValid(SimulationRequest request) {
        return request.getNumberOfSimulations() > 0;
    }

}
