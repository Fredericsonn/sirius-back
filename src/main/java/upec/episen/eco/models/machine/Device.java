package upec.episen.eco.models.machine;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import upec.episen.eco.models.machine.enums.UsageCategory;

import java.util.List;
import java.util.Set;

@Entity
public class Device extends Machine {

    @Column
    private double power;

    // No-argument constructor
    public Device() {
        super();
    }

    // Constructor without footprint
    public Device(String name, UsageCategory usage, double footprint, Set<Component> resources, double power) {
        super(name, footprint, usage, resources);
        this.power = power;
    }


    // Getters and Setters
    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Device{" +
                "power=" + power +
                "} " + super.toString();
    }
}