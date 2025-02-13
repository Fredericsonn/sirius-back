package upec.episen.eco.models.consumption;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="consumption_item")
public class ConsumptionItem {

    @Column
    private String name;

    @Id
    private long id;

    @Column(name = "energy_input")
    private double energyInput;
    
    @Column
    private double usageFrequency;

    @Column
    private long quatity;

    @Column
    private double carbonFootprint;

    @ManyToOne
    @JoinColumn(name = "consumption_id", nullable = false)
    private Consumption consumption;

    public ConsumptionItem(long id, double usageFrequency, long quatity, double carbonFootprint) {
        this.id = id;
        this.usageFrequency = usageFrequency;
        this.quatity = quatity;
        this.carbonFootprint = carbonFootprint;
    }

    public ConsumptionItem() {}

    // Ajouter cette méthode getter pour accéder à l'entité Comsumption
    public Consumption getConsumption() {
        return consumption;
    }

    public void setConsumption(Consumption consumption) {
        this.consumption = consumption;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getEnergyInput() {
        return energyInput;
    }

    public void setEnergyInput(double energyInput) {
        this.energyInput = energyInput;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ConsumptionItem [name=" + name + ", id=" + id + ", energyInput=" + energyInput + ", usageFrequency="
                + usageFrequency + ", quatity=" + quatity + ", carbonFootprint=" + carbonFootprint + ", consumption="
                + consumption + "]";
    }


    
}
