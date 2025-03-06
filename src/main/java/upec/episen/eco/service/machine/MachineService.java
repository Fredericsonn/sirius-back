package upec.episen.eco.service.machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upec.episen.eco.exceptions.ConsumptionNotFoundException;
import upec.episen.eco.models.consumption.Consumption;
import upec.episen.eco.models.consumption.ConsumptionItem;
import upec.episen.eco.models.machine.*;
import upec.episen.eco.models.machine.Algo.MatterImpactScore;
import upec.episen.eco.models.machine.enums.UsageCategory;
import upec.episen.eco.repositories.machine.IDevice;
import upec.episen.eco.repositories.machine.IVehicle;
import upec.episen.eco.service.consumption.ConsumptionService;

@Service
public class MachineService{

    @Autowired
    private IDevice devicerepo;

    @Autowired
    private IVehicle vehiclerepo;
    @Autowired
    private ConsumptionService consumptionService;

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
