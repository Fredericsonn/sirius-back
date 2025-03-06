package upec.episen.eco.service.User;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upec.episen.eco.exceptions.CollectionNotFoundException;
import upec.episen.eco.exceptions.UserNotFoundException;
import upec.episen.eco.models.User.Collection;
import upec.episen.eco.models.User.User;
import upec.episen.eco.models.machine.*;
import upec.episen.eco.models.machine.Algo.MatterImpactScore;
import upec.episen.eco.repositories.User.ICollection;
import upec.episen.eco.repositories.User.IUser;

@Service
public class CollectionService {

    @Autowired
    private ICollection icollection;

    @Autowired
    private IUser iuser;

    public List<Collection> getAllCollections() {
        return icollection.findAll();
    }

    public List<Collection> getAllCollectionsByUser(Long id) throws UserNotFoundException {
        Optional<User> user = iuser.findById(id);

        if (user.isPresent()) return icollection.findAllByUser(user.get());

        else throw new UserNotFoundException(id);
    }

    public Collection getCollectionByUserAndName(Long id, String name) throws UserNotFoundException {
        Optional<User> user = iuser.findById(id);

        if (user.isPresent()) return icollection.findByUserAndName(user.get(), name);

        else throw new UserNotFoundException(id);
    }

    public Collection getCollectionById(Long id) throws CollectionNotFoundException {
        Optional<Collection> collection = icollection.findById(id);

        if (collection.isPresent()) return collection.get();

        throw new CollectionNotFoundException(id);
    }

    public Set<Machine> getCollectionMachines(Collection collection) {
        return collection.getMachines();
    }

    public Collection saveCollection(Collection collection, Long userId) throws UserNotFoundException {
        Optional<User> user = iuser.findById(userId);
        Set<Machine> refinedCollections = new HashSet<>();
        collection.getMachines().forEach(machine -> {
            if (machine instanceof Device) machine = (Device) machine;
            else machine = (Vehicle) machine;
            refinedCollections.add(machine);
        });
        if (user.isPresent()) {
            collection.setUser(user.get());
            collection.setMachines(refinedCollections);
            return icollection.save(collection);
        }

        else throw new UserNotFoundException(userId);
    }
//Algorithme khalil pour le calcule de l'impact materiel
    public double calculateCollectionImpact(Long collectionId) throws CollectionNotFoundException {
        Collection collection = getCollectionById(collectionId);
        Set<Machine> machines = collection.getMachines();

        double totalImpact = 0;
        double totalVolume = 0;
        Map<String, Double> materialUsage = new HashMap<>();

        for (Machine machine : machines) {
            for (Component component : machine.getResources()) {
                for (Matter matter : component.getMatters()) {
                    String material = matter.getValue();
                    double volume = matter.getVolume();

                    double impactFactor = MatterImpactScore.getImpactFactor(material);
                    double materialImpact = volume * impactFactor;

                    totalImpact += materialImpact;
                    totalVolume += volume;

                    materialUsage.put(material, materialUsage.getOrDefault(material, 0.0) + volume);
                }
            }
        }


        double averageImpact = totalImpact / totalVolume;
        double baseScore = Math.max(1, 10 - (averageImpact * 100));

        double volumeAdjustment = MatterImpactScore.calculateUsageAdjustment(materialUsage);

        double finalScore = baseScore + volumeAdjustment;

        double result = Math.max(1, Math.min(10, finalScore));

        BigDecimal bd = new BigDecimal(result);
        return bd.doubleValue();
    }
}

