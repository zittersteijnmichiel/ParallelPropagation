package MonteCarlo;

import org.orekit.orbits.Orbit;

public class OrekitPropagationMonteCarloSample implements MonteCarloSample {

    Orbit orbit;

    public OrekitPropagationMonteCarloSample(Orbit orbit) {
        this.orbit = orbit;
    }
}
