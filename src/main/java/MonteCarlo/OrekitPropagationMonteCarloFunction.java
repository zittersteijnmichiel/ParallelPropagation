package MonteCarlo;

import org.orekit.errors.OrekitException;
import org.orekit.orbits.Orbit;
import org.orekit.propagation.SpacecraftState;
import org.orekit.propagation.analytical.KeplerianPropagator;

public class OrekitPropagationMonteCarloFunction implements MonteCarloFunction {

    Orbit orbit;
    double propagationTime;

    public OrekitPropagationMonteCarloFunction(Orbit orbit, double propagationTime) {
        this.orbit = orbit;
        this.propagationTime = propagationTime;
    }

    public OrekitPropagationMonteCarloOutput run() {
        try {
            KeplerianPropagator keplerianPropagator = new KeplerianPropagator(orbit);
            SpacecraftState spacecraftState = keplerianPropagator.propagate(orbit.getDate().shiftedBy(this.propagationTime));
            OrekitPropagationMonteCarloOutput output = new OrekitPropagationMonteCarloOutput(spacecraftState);
            return output;
        } catch (OrekitException e) {
            e.printStackTrace();
        }
        return null;
    }
}
