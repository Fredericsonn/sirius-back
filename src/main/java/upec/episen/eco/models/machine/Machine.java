package upec.episen.eco.models.machine;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.PrimaryKeyJoinColumns;
import upec.episen.eco.models.machine.enums.Resource;
import upec.episen.eco.models.machine.enums.UsageCategory;

import java.util.ArrayList;


class Machine {
    @PrimaryKeyJoinColumn
    private int id;
    @Column
    private String name;
    @Column
    private double defaultFootpring;
    @Column
    private UsageCategory usage;

    private ArrayList<Resource> resources;

    public Machine(){}

    public Machine(int id,String name,double f,UsageCategory us,ArrayList<Resource> r){
        this.id=id;
        this.name=name;
        this.defaultFootpring=f;
        this.usage=us;
        this.resources=r;
    }

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
