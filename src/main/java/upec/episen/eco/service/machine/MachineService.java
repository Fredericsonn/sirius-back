package upec.episen.eco.service.machine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upec.episen.eco.models.machine.*;
import upec.episen.eco.models.machine.enums.UsageCategory;
import upec.episen.eco.models.machine.enums.VehicleSize;
import upec.episen.eco.models.machine.enums.VehicleType;
import upec.episen.eco.repositories.machine.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class MachineService {

    @Autowired
    private IComponent componentRepository;

    @Autowired
    private IMatter matterRepository;

    @Autowired
    private IDevice deviceRepository;

    @Autowired
    private IVehicule vehicleRepository;

    @Autowired
    private IMachine imachine;

    /**
     * Creates a new Device with footprint
     */
    public Device createDevice(String name, UsageCategory usage, Set<Component> resources, double power) {
        Device device = new Device();
        device.setName(name);
        device.setUsage(usage);
        device.setPower(power);
        device.setResources(resources);
        return deviceRepository.save(device);
    }

    /**
     * Creates a new Vehicle
     */
    public Vehicle createVehicle(String name,
                                 UsageCategory usage,
                                 VehicleSize size,
                                 VehicleType type) {
        Vehicle vehicle = new Vehicle();
        vehicle.setName(name);
        vehicle.setUsage(usage);
        vehicle.setSize(size);
        vehicle.setType(type);
        return vehicleRepository.save(vehicle);
    }


    /**
     * Creates a new Matter
     */
    public Matter createMatter(String value, double volume) {
        Matter matter = new Matter(value, volume);
        return matterRepository.save(matter);
    }

    /**
     * Adds a component to a machine
     */
    public Machine addComponentToDevice(int deviceId, Component component) {
        Device machine = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new IllegalArgumentException("Machine not found"));
        machine.getResources().add(component);
        return deviceRepository.save(machine);
    }

    public Machine addComponentToVehicule(int deviceId, Component component) {
        Vehicle machine = vehicleRepository.findById(deviceId)
                .orElseThrow(() -> new IllegalArgumentException("Machine not found"));
        machine.getResources().add(component);
        return vehicleRepository.save(machine);
    }

    /**
     * Adds a matter to a component
     */
    public Component addMatterToComponent(Long componentId, Matter matter) {
        Component component = componentRepository.findById(componentId)
                .orElseThrow(() -> new IllegalArgumentException("Component not found"));
        component.addMatter(matter);
        return componentRepository.save(component);
    }

    // Autres méthodes utiles
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public List<Vehicle> getAllVehicues() {
        return vehicleRepository.findAll();
    }

    public Device getDeviceById(int id) {
        return deviceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Machine not found"));
    }

    public Vehicle getVehiculeById(int id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Machine not found"));
    }

    public List<Device> getDevicesByUsage(UsageCategory usage) {
        return deviceRepository.findByUsage(usage);
    }

    public List<Vehicle> getVehicleByUsage(UsageCategory usage) {
        return vehicleRepository.findByUsage(usage);
    }

    /*public List<Machine> saveMachines(List<? extends Machine> machines) {
        List<Machine> savedMachines = new ArrayList<>();
        for (Machine machine : machines) {
            if (machine instanceof Device) {
                machine = (Device) machine;
            } else if (machine instanceof Vehicle) {
                machine = (Vehicle) machine;
            }
            savedMachines.add(imachine.save(machine));
        }
        return savedMachines;
    }*/
    /*public List<Machine> saveMachines(List<? extends Machine> machines) {
        List<Machine> savedMachines = new ArrayList<>();
        for (Machine machine : machines) {
            // Ensure proper bidirectional relationship
            if (machine.getResources() != null) {
                for (Component component : machine.getResources()) {
                    component.setMachine(machine);
                }
            }

            if (machine instanceof Device) {
                machine = deviceRepository.save((Device) machine);
            } else if (machine instanceof Vehicle) {
                machine = vehicleRepository.save((Vehicle) machine);
            }
            savedMachines.add(machine);
        }
        return savedMachines;
    }*/
    public List<Machine> saveMachines(List<? extends Machine> machines) {
        List<Machine> savedMachines = new ArrayList<>();
        for (Machine machine : machines) {
            if (machine.getResources() != null) {
                Set<Component> components = new HashSet<>(machine.getResources());
                machine.getResources().clear();

                for (Component component : components) {
                    component.setMachine(machine);

                    // Gérer les matters
                    if (component.getMatters() != null) {
                        Set<Matter> matters = new HashSet<>(component.getMatters());
                        component.getMatters().clear();

                        for (Matter matter : matters) {
                            component.addMatter(matter);
                        }
                    }

                    machine.getResources().add(component);
                }
            }

            Machine savedMachine = imachine.save(machine);
            savedMachines.add(savedMachine);
        }
        return savedMachines;
    }
    public List<Machine> getAllMachines() {
        return imachine.findAll();
    }
}