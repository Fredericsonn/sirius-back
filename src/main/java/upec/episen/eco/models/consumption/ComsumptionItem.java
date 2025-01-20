package upec.episen.eco.models.consumption;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name="consumption_item")
public class ComsumptionItem {

    @Id
    private long id;

    @Column
    private double usageFrequency;

    @Column
    private long quatity;

    @Column
    private double carbonFootprint;

    @ManyToOne
    private Comsumption comsumption;

    public ComsumptionItem(long id, double usageFrequency, long quatity, double carbonFootprint) {
        this.id = id;
        this.usageFrequency = usageFrequency;
        this.quatity = quatity;
        this.carbonFootprint = carbonFootprint;
    }

    public ComsumptionItem() {}

    // Ajouter cette méthode getter pour accéder à l'entité Comsumption
    public Comsumption getConsumption() {
        return comsumption;
    }

    public void setConsumption(Comsumption consumption) {
        this.comsumption = consumption;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getUsageFrequency() {
        return usageFrequency;
    }

    public void setUsageFrequency(double usageFrequency) {
        this.usageFrequency = usageFrequency;
    }

    public long getQuatity() {
        return quatity;
    }

    public void setQuatity(long quatity) {
        this.quatity = quatity;
    }

    public double getCarbonFootprint() {
        return carbonFootprint;
    }

    public void setCarbonFootprint(double carbonFootprint) {
        this.carbonFootprint = carbonFootprint;
    }

    @Override
    public String toString() {
        return "ComsumptionItem{" +
                "id=" + id +
                ", usageFrequency=" + usageFrequency +
                ", quatity=" + quatity +
                ", carbonFootprint=" + carbonFootprint +
                '}';
    }
}
