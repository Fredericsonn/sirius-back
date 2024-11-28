package upec.episen.eco.models.machine;

import jakarta.persistence.*;
import upec.episen.eco.models.machine.enums.Resource;
import upec.episen.eco.models.machine.enums.UsageCategory;
import upec.episen.eco.models.machine.enums.VehicleSize;
import upec.episen.eco.models.machine.enums.VehicleType;

import java.util.ArrayList;

@Entity
public class Vehicle extends Machine {

    @Enumerated(EnumType.STRING)
    private VehicleSize size;

    @Enumerated(EnumType.STRING)
    private VehicleType type;

    public Vehicle(int id, String name, double f, UsageCategory us, ArrayList<Resource> r, VehicleSize size, VehicleType type) {
        super(id, name, f, us, r);
        this.size = size;
        this.type = type;
    }

    public Vehicle() {}

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