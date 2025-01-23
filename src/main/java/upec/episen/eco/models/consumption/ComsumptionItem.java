package upec.episen.eco.models.consumption;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="consumption_item")
public class ComsumptionItem {


    @Column
    private String name;

    @Id
    private long id;

    @Column
    private Double usageFrequency;

    @Column
    private long quatity;

    @Column
    private Double carbonFootprint;

    @ManyToOne
    @JoinColumn(name = "consumption_id", nullable = false)
    private Comsumption comsumption;

    public ComsumptionItem(long id, Double usageFrequency, long quatity, Double carbonFootprint) {
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

    public Double getUsageFrequency() {
        return usageFrequency;
    }

    public void setUsageFrequency(Double usageFrequency) {
        this.usageFrequency = usageFrequency;
    }

    public long getQuatity() {
        return quatity;
    }

    public void setQuatity(long quatity) {
        this.quatity = quatity;
    }

    public Double getCarbonFootprint() {
        return carbonFootprint;
    }

    public void setCarbonFootprint(Double carbonFootprint) {
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
        return "ComsumptionItem{" +
                "id=" + id +
                ", usageFrequency=" + usageFrequency +
                ", quatity=" + quatity +
                ", carbonFootprint=" + carbonFootprint +
                '}';
    }
}
