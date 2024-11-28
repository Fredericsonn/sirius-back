package upec.episen.eco.models.machine;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import upec.episen.eco.models.machine.enums.Resource;
import upec.episen.eco.models.machine.enums.UsageCategory;

import java.util.ArrayList;


public class Device extends Machine{

    @Column
    private int power;
    public Device(int id, String name, double f, UsageCategory us, ArrayList<Resource> r,int p) {
        super(id, name, f, us, r);
        this.power=p;
    }
    public Device(){}

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Device{" +
                "power=" + power +
                '}';
    }
}
