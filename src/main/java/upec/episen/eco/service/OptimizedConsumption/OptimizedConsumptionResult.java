package upec.episen.eco.service.OptimizedConsumption;

import upec.episen.eco.models.consumption.Consumption;

public class OptimizedConsumptionResult {
    private double[] optimizedFrequencies;
    private Consumption consumption;
    private double savedCarbon;

    public OptimizedConsumptionResult(double[] optimizedFrequencies, Consumption consumption, double savedCarbon) {
        this.optimizedFrequencies = optimizedFrequencies;
        this.consumption = consumption;
        this.savedCarbon = savedCarbon;
    }

    public double[] getOptimizedFrequencies() {
        return optimizedFrequencies;
    }

    public Consumption getConsumption() {
        return consumption;
    }

    public double getSavedCarbon() {
        return this.savedCarbon;
    }
}
