package upec.episen.eco.models.machine;


import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import upec.episen.eco.models.machine.enums.UsageCategory;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column(name = "default_footprint")
    private double defaultFootprint;

    @Column
    @Enumerated(EnumType.STRING)
    private UsageCategory usage;

    @OneToMany(mappedBy = "machine", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference // Add this annotation
    private Set<Component> resources = new HashSet<>();

    // Full constructor
    protected Machine(String name, double footprint, UsageCategory usage, Set<Component> resources) {
        this.name = name;
        this.defaultFootprint = footprint;
        this.usage = usage;
        this.resources = resources;
    }

    public Machine() {
    }
    public void addResource(Component component) {
        resources.add(component);
        component.setMachine(this);
    }

    public void removeResource(Component component) {
        resources.remove(component);
        component.setMachine(null);
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDefaultFootprint() {
        return defaultFootprint;
    }

    public void setDefaultFootprint(double defaultFootprint) {
        this.defaultFootprint = defaultFootprint;
    }

    public UsageCategory getUsage() {
        return usage;
    }

    public void setUsage(UsageCategory usage) {
        this.usage = usage;
    }

    public Set<Component> getResources() {
        return resources;
    }

    public void setResources(Set<Component> resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", defaultFootprint=" + defaultFootprint +
                ", usage=" + usage +
                ", resources=" + resources +
                '}';
    }
}