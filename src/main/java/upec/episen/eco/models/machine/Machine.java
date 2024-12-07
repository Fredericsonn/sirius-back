package upec.episen.eco.models.machine;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import upec.episen.eco.models.machine.enums.Resource;
import upec.episen.eco.models.machine.enums.UsageCategory;


@MappedSuperclass
public abstract class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column(name="default_footprint")
    private double defaultFootpring;

    @Column
    @Enumerated(EnumType.STRING)
    private UsageCategory usage;

    @ElementCollection
    private ArrayList<Resource> resources;

    
    public Machine(int id, String name, double f, UsageCategory us, ArrayList<Resource> r) {
        this.id = id;
        this.name = name;
        this.defaultFootpring = f;
        this.usage = us;
        this.resources = r;
    }
    
    public Machine() {}
    
    // Getters and setters

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

    public double getDefaultFootpring() {
        return defaultFootpring;
    }

    public void setDefaultFootpring(double defaultFootpring) {
        this.defaultFootpring = defaultFootpring;
    }

    public UsageCategory getUsage() {
        return usage;
    }

    public void setUsage(UsageCategory usage) {
        this.usage = usage;
    }

    public ArrayList<Resource> getResources() {
        return resources;
    }

    public void setResources(ArrayList<Resource> resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", defaultFootpring=" + defaultFootpring +
                ", usage=" + usage +
                ", resources=" + resources +
                '}';
    }
}
