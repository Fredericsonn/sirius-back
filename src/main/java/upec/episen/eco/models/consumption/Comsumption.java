package upec.episen.eco.models.consumption;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Comsumption {
    @Id
    private long id;
    @Column
    private String name;
    @Column
    private double totalCarbonEmitted;

    public Comsumption(long id, String name, double totalCarbonEmitted) {
        this.id = id;
        this.name = name;
        this.totalCarbonEmitted = totalCarbonEmitted;
    }

    public Comsumption() {}

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
