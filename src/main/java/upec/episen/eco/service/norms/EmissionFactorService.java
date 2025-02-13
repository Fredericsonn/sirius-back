package upec.episen.eco.service.norms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upec.episen.eco.models.consumption.EnergyType;
import upec.episen.eco.repositories.norms.IEmissionFactor;

@Service
public class EmissionFactorService {

    @Autowired
    private IEmissionFactor ifactor;

    public double getEmissionFactorByEnergyType(EnergyType type) {
        return ifactor.findByEnergyType(type).getEmissionFactor();
    }
}
