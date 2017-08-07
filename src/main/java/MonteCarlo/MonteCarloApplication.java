package MonteCarlo;

import org.orekit.errors.OrekitException;
import org.orekit.frames.FramesFactory;
import org.orekit.orbits.KeplerianOrbit;
import org.orekit.orbits.Orbit;
import org.orekit.orbits.PositionAngle;
import org.orekit.time.AbsoluteDate;
import org.orekit.time.TimeScalesFactory;
import org.orekit.utils.Constants;

public class MonteCarloApplication {
    public static void main(String[] args) {

        AbsoluteDate startDate = new AbsoluteDate(2017, 5, 1,
                0, 10, 10, TimeScalesFactory.getTAI());

        Orbit orbit = new KeplerianOrbit(4.2e7, 0.01, 1, 1, 1, 1, PositionAngle.MEAN,
                FramesFactory.getEME2000(), startDate, Constants.WGS84_EARTH_MU);

        ParallelMonteCarlo monteCarlo = new OrekitPropagationParallelMonteCarlo();
        monteCarlo.generateSamples(10, new OrekitPropagationMonteCarloSample(orbit));
    }
}
