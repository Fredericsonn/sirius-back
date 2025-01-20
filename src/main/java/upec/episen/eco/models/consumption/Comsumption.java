package upec.episen.eco.models.consumption;

<<<<<<< HEAD
import java.time.LocalDate;
=======
import java.util.Set;
>>>>>>> f3f15df (select by)

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Comsumption {

    @Id
    private long id;

    @Column
    private String name;

    @Column
    private double totalCarbonEmitted;

<<<<<<< HEAD
    @Column
    private LocalDate createdAt;
=======
    @OneToMany(mappedBy = "comsumption")
    private Set<ComsumptionItem> ComsumptionItem;
>>>>>>> f3f15df (select by)

    public Comsumption(long id, String name, double totalCarbonEmitted) {
        this.id = id;
        this.name = name;
        this.totalCarbonEmitted = totalCarbonEmitted;
        this.createdAt = LocalDate.now();
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
