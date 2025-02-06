package upec.episen.eco.models.machine;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import upec.episen.eco.models.User.Collection;
import upec.episen.eco.models.machine.enums.Resource;
import upec.episen.eco.models.machine.enums.UsageCategory;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    private String name;

    @Column(name = "default_footprint")
    private double defaultFootprint;

    @Column
    @Enumerated(EnumType.STRING)
    private UsageCategory usage;

    @Column
    private String img;

    @ElementCollection
    private List<Resource> resources;

    @ManyToOne
    private Collection collection;

    public Machine(int id, String name, double f, UsageCategory us, String img, List<Resource> r) {
        this.id = id;
        this.name = name;
        this.defaultFootprint = f;
        this.usage = us;
        this.img = img;
        this.resources = r;
    }

    public Machine() {
    }

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

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", defaultFootpring=" + defaultFootprint +
                ", usage=" + usage +
                ", img=" + img +
                ", resources=" + resources +
                '}';
    }

}
