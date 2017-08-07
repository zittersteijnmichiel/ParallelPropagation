package MonteCarlo;

import java.util.ArrayList;
import java.util.List;

public class OrekitPropagationParallelMonteCarlo implements ParallelMonteCarlo {

    MonteCarloSampleGenerator sampleGenerator;
    List<OrekitPropagationMonteCarloSample> samples;
    double propagationTime = 24 * 3600;
    List<OrekitPropagationMonteCarloOutput> output;

    public void generateSamples(int numberOfSamples, MonteCarloSample startFromThisSample) {
        sampleGenerator = new OrekitPropagationMonteCarloSampleGenerator((OrekitPropagationMonteCarloSample) startFromThisSample);
        samples = new ArrayList<OrekitPropagationMonteCarloSample>();
        for(int i = 0; i < numberOfSamples; i++) {
            samples.add((OrekitPropagationMonteCarloSample) sampleGenerator.generateSample());
        }
    }

    public void processSamples(int numberOfCPUs) {
        for(int i = 0; i < samples.size(); i++) {
            output.add(new OrekitPropagationMonteCarloFunction(samples.get(i).orbit, propagationTime).run());
        }
    }

    public List<MonteCarloOutput> getOutput() {
        return null;
    }
}
