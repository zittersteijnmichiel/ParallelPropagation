package MonteCarlo;

import org.orekit.frames.FramesFactory;
import org.orekit.orbits.KeplerianOrbit;
import org.orekit.orbits.Orbit;
import org.orekit.orbits.PositionAngle;
import org.orekit.utils.Constants;

import java.util.Random;

public class OrekitPropagationMonteCarloSampleGenerator implements MonteCarloSampleGenerator {

    OrekitPropagationMonteCarloSample orekitPropagationMonteCarloSample;
    static Random random = new Random();

    public OrekitPropagationMonteCarloSampleGenerator(OrekitPropagationMonteCarloSample orekitPropagationMonteCarloSample) {
        this.orekitPropagationMonteCarloSample = orekitPropagationMonteCarloSample;
    }

    public MonteCarloSample generateSample() {
        Orbit orbitSample = addNoiseToOrbit(orekitPropagationMonteCarloSample.orbit);
        return new OrekitPropagationMonteCarloSample(orbitSample);
    }

    private Orbit addNoiseToOrbit(Orbit orbit) {
        KeplerianOrbit keplerianOrbit = new KeplerianOrbit(orekitPropagationMonteCarloSample.orbit);
        double newA = keplerianOrbit.getA() + random.nextGaussian();
        double newE = keplerianOrbit.getE() + random.nextGaussian();
        double newI = keplerianOrbit.getI() + random.nextGaussian();
        double newRAAN = keplerianOrbit.getRightAscensionOfAscendingNode() + random.nextGaussian();
        double newPa = keplerianOrbit.getPerigeeArgument() + random.nextGaussian();
        double newM = keplerianOrbit.getAnomaly(PositionAngle.MEAN) + random.nextGaussian();
        return new KeplerianOrbit(newA, newE, newI, newRAAN, newPa, newM, PositionAngle.MEAN,
                FramesFactory.getEME2000(), keplerianOrbit.getDate(), Constants.WGS84_EARTH_MU);
    }
}
