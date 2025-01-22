package upec.episen.eco.models.machine;

import jakarta.persistence.*;
import upec.episen.eco.models.machine.enums.UsageCategory;
import upec.episen.eco.models.machine.enums.VehicleSize;
import upec.episen.eco.models.machine.enums.VehicleType;

import java.util.List;
import java.util.Set;

@Entity
public class Vehicle extends Machine {

    @Column
    private String name;

    @Column(name = "vehicle_size")
    @Enumerated(EnumType.STRING)
    private VehicleSize size;

    @Column(name = "vehicle_type")
    @Enumerated(EnumType.STRING)
    private VehicleType type;

    // No-argument constructor
    public Vehicle() {
        super();
    }

    // Full constructor
    public Vehicle(String name, UsageCategory usage, double footprint, Set<Component> resources,VehicleSize vehicleSize, VehicleType vehicleType) {
        super(name, footprint,usage,resources);
        this.size = vehicleSize;
        this.type = vehicleType;
    }

    // Getters and Setters
    public VehicleSize getSize() {
        return size;
    }

    public void setSize(VehicleSize size) {
        this.size = size;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "size=" + size +
                ", type=" + type +
                "} " + super.toString();
    }
}