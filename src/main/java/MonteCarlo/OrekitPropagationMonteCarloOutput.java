package MonteCarlo;

import org.orekit.propagation.SpacecraftState;

public class OrekitPropagationMonteCarloOutput implements MonteCarloOutput {

    SpacecraftState spacecraftState;

    public OrekitPropagationMonteCarloOutput(SpacecraftState spacecraftState) {
        this.spacecraftState = spacecraftState;
    }

}
