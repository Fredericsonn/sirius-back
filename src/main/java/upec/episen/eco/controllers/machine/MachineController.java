package upec.episen.eco.controllers.machine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upec.episen.eco.models.machine.Device;
import upec.episen.eco.models.machine.Machine;
import upec.episen.eco.models.machine.Vehicle;
import upec.episen.eco.service.machine.MachineService;

import java.util.List;

@RestController
@RequestMapping("/machines")
public class MachineController {

    @Autowired
    private MachineService machineservice;
    @GetMapping
    public List<Machine> getAllMachines() {
        return machineservice.getAllMachines();
    }

}