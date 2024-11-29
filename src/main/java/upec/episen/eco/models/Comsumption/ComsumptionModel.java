package upec.episen.eco.models.Comsumption;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;


@Entity
public class ComsumptionModel {
    @Id
    private long id;
    @Column
    private String name;
    @Column
    private double totalCarbonEmitted;

    public ComsumptionModel(long id, String name, double totalCarbonEmitted) {
        this.id = id;
        this.name = name;
        this.totalCarbonEmitted = totalCarbonEmitted;
    }

    public ComsumptionModel() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalCarbonEmitted() {
        return totalCarbonEmitted;
    }

    public void setTotalCarbonEmitted(double totalCarbonEmitted) {
        this.totalCarbonEmitted = totalCarbonEmitted;
    }

    @Override
    public String toString() {
        return "Comsumption{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalCarbonEmitted=" + totalCarbonEmitted +
                '}';
    }
}
