package MonteCarlo;

import java.util.List;

public interface ParallelMonteCarlo {
    void generateSamples(int numberOfSamples, MonteCarloSample startFromThisSample);
    void processSamples(int numberOfCPUs);
    List<MonteCarloOutput> getOutput();
}
