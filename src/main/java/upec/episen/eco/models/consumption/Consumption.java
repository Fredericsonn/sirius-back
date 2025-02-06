package upec.episen.eco.models.consumption;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Consumption {

    @Id
    private long id;

    @Column
    private String name;

    @Column
    private double totalCarbonEmitted;

    @Column
    private LocalDate createdAt;

    @OneToMany(mappedBy = "comsumption", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ConsumptionItem> ComsumptionItems;

    public Consumption(long id, String name, double totalCarbonEmitted) {
        this.id = id;
        this.name = name;
        this.totalCarbonEmitted = totalCarbonEmitted;
        this.createdAt = LocalDate.now();
    }

    public Consumption() {}


    public void setConsumptionItems(Set<ConsumptionItem> c){
        this.ComsumptionItems=c;
    }

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
    
    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Comsumption [id=" + id + ", name=" + name + ", totalCarbonEmitted=" + totalCarbonEmitted
                + ", createdAt=" + createdAt + "]";
    }
}
