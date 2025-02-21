package upec.episen.eco.service.consumption;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upec.episen.eco.exceptions.ConsumptionNotFoundException;
import upec.episen.eco.exceptions.UserNotFoundException;
import upec.episen.eco.models.User.User;
import upec.episen.eco.models.consumption.Consumption;
import upec.episen.eco.models.consumption.ConsumptionItem;
import upec.episen.eco.models.consumption.EnergyType;
import upec.episen.eco.models.machine.Device;
import upec.episen.eco.models.machine.Machine;
import upec.episen.eco.repositories.consumption.IConsumption;
import upec.episen.eco.service.User.UserService;
import upec.episen.eco.service.norms.EmissionFactorService;

@Service
public class ConsumptionService {

    @Autowired
    private IConsumption iconsumption;

    @Autowired
    private UserService userservice;

    @Autowired
    private EmissionFactorService emissionFactorService;

    public List<Consumption> getAllConsumptions() {
        return iconsumption.findAll();
    }

    public List<Consumption> getAllConsumptionsByUser(Long userId) throws UserNotFoundException {
        User user = userservice.getUserById(userId);
        return iconsumption.findAllByUser(user);
    }

    public Consumption getConsumptionById(Long id) throws ConsumptionNotFoundException {
        Optional<Consumption> consumption = iconsumption.findById(id);

        if (consumption.isPresent())
            return consumption.get();

        throw new ConsumptionNotFoundException(id);
    }

    public List<ConsumptionItem> getOrderedItemsById(Long id) {
        return iconsumption.getOrderedItemsById(id);
    }

    public Consumption saveConsumption(Consumption consumption) {
        // we calculate each consumption item's emitted carbon
        consumption.getConsumptionItems().forEach(item -> item.setCarbonFootprint(calculateItemCarbonEmitted(item, item.getEnergyType())));

        // we sum each item's emitted carbon and set it as the consumption's total emission
        consumption.setTotalCarbonEmitted(calculateTotalCarbonEmitted(consumption));

        consumption.setCreatedAt(LocalDate.now());

        return iconsumption.save(consumption);
    }

    private double calculateTotalCarbonEmitted(Consumption consumption) {
        return consumption.getConsumptionItems().stream().mapToDouble(item -> item.getCarbonFootprint()).sum();
    }

    public double calculateItemCarbonEmitted(ConsumptionItem item, EnergyType type) {
        double emissionFactor = emissionFactorService.getEmissionFactorByEnergyType(type);
        Machine machine = item.getMachine();
        double carbonemitted;

        if (machine instanceof Device) carbonemitted = item.getEnergyInput() * item.getUsageFrequency() * emissionFactor;

        else carbonemitted = item.getUsageFrequency() * emissionFactor;

        // the provided values for ELECTRICITY type are in watts, so we converted it to kwh
        if (type == EnergyType.ELECTRICITY) carbonemitted /= 1000; 

        BigDecimal bd = new BigDecimal(carbonemitted);
        bd = bd.setScale(2, RoundingMode.HALF_UP ); // we round the calculated value to 2 numbers after the comma

        return bd.doubleValue();
    }
}