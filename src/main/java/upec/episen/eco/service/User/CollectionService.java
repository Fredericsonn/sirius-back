package upec.episen.eco.service.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upec.episen.eco.exceptions.CollectionNotFoundException;
import upec.episen.eco.models.User.Collection;
import upec.episen.eco.models.User.User;
import upec.episen.eco.models.machine.Machine;
import upec.episen.eco.repositories.User.ICollection;

@Service
public class CollectionService {

    @Autowired
    private ICollection icollection;

    public List<Collection> getAllCollections() {
        return icollection.findAll();
    }

    public List<Collection> getAllCollectionsByUser(User user) {
        return icollection.findAllByUser(user);
    }

    public Collection getCollectionById(Long id) throws CollectionNotFoundException {
        Optional<Collection> collection = icollection.findById(id);

        if (collection.isPresent()) return collection.get();

        throw new CollectionNotFoundException(id);
    }

    public Set<Machine> getCollectionMachines(Collection collection) {
        return collection.getMachines();
    }

}
