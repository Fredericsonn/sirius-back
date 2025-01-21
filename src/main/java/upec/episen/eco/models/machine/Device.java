package upec.episen.eco.models.machine;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import upec.episen.eco.models.machine.enums.Resource;
import upec.episen.eco.models.machine.enums.UsageCategory;


@Entity
public class Device extends Machine {

    @Column
    private double power;

    public Device(int id, String name, double f, UsageCategory us, String img, ArrayList<Resource> r, double p) {
        super(id, name, f, us, img, r);
        this.power = p;
    }

    public Device() {}

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
