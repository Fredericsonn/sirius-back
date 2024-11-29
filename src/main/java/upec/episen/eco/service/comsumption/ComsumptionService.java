package upec.episen.eco.service.comsumption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upec.episen.eco.models.Comsumption.ComsumptionModel;
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
