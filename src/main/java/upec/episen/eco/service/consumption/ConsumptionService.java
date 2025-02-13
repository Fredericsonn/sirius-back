package upec.episen.eco.service.consumption;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upec.episen.eco.exceptions.ConsumptionNotFoundException;
import upec.episen.eco.exceptions.UserNotFoundException;
import upec.episen.eco.models.User.User;
import upec.episen.eco.models.consumption.Consumption;
import upec.episen.eco.models.consumption.ConsumptionItem;
import upec.episen.eco.repositories.consumption.IConsumption;
import upec.episen.eco.service.User.UserService;

@Service
public class ConsumptionService {

    @Autowired
    private IConsumption iconsumption;

    @Autowired
    private UserService userservice;

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
        return iconsumption.save(consumption);
    }



}