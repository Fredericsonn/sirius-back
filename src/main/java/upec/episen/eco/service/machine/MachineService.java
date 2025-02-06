package upec.episen.eco.service.machine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upec.episen.eco.models.machine.Device;
import upec.episen.eco.models.machine.Machine;
import upec.episen.eco.models.machine.Vehicle;
import upec.episen.eco.models.machine.enums.UsageCategory;
import upec.episen.eco.repositories.machine.IDevice;
import upec.episen.eco.repositories.machine.IVehicle;

@Service
public class MachineService {

    @Autowired
    private IDevice devicerepo;

    @Autowired
    private IVehicle vehiclerepo;

    public List<Device> getAllDevices() {
        return devicerepo.findAll();
    } 

    public List<Vehicle> getAllVehicles() {
        return vehiclerepo.findAll();
    }

    public List<Machine> getAllMachines() {
        List<Machine> machines = new ArrayList<>();
        List<Device> devices = getAllDevices();
        List<Vehicle> vehicles = getAllVehicles();
        machines.addAll(devices);
        machines.addAll(vehicles);

        return machines;
    }

    public List<Machine> getAllMachinesByUsageCategory(UsageCategory category) {
        List<Machine> machines = new ArrayList<>();

        if (category.equals(UsageCategory.TRANSPORT))  machines.addAll(vehiclerepo.findAllByUsage(category));

        else machines.addAll(devicerepo.findAllByUsage(category));

        return machines;
    }

}
