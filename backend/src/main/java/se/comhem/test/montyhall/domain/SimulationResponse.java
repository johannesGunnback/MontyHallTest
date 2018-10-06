package se.comhem.test.montyhall.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class SimulationResponse {

    private BigDecimal winPercentage;
}
