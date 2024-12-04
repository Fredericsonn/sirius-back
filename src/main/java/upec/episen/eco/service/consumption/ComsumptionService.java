package upec.episen.eco.service.consumption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upec.episen.eco.models.consumption.ComsumptionModel;
import upec.episen.eco.repositories.comsumption.Comsumption;

import java.util.List;

@Service
public class ComsumptionService {
    @Autowired
    Comsumption consumptiondao;

    public List<ComsumptionModel> getAll(){
        return consumptiondao.findAll();

    }

}
