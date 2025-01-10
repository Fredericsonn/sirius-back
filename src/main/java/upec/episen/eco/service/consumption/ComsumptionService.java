package upec.episen.eco.service.consumption;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upec.episen.eco.models.consumption.Comsumption;
import upec.episen.eco.models.machine.enums.UsageCategory;
import upec.episen.eco.repositories.comsumption.IComsumption;

@Service
public class ComsumptionService {
    
    @Autowired
    private IComsumption consumptionrepo;

    public List<Comsumption> getAll(){
        return consumptionrepo.findAll();
    }

}
