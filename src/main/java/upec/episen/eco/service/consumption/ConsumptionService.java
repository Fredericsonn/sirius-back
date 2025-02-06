package upec.episen.eco.service.consumption;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upec.episen.eco.models.consumption.Consumption;
import upec.episen.eco.models.machine.enums.UsageCategory;
import upec.episen.eco.repositories.comsumption.IConsumption;

@Service
public class ConsumptionService {
    
    @Autowired
    private IConsumption consumptionrepo;

    public List<Consumption> getAll(){
        return consumptionrepo.findAll();
    }

}
