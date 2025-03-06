package upec.episen.eco.controllers.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upec.episen.eco.exceptions.CollectionNotFoundException;
import upec.episen.eco.service.User.CollectionService;

@RestController
@RequestMapping("/api/collection")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @GetMapping("/{id}/impact")
    public ResponseEntity<Double> getCollectionImpact(@PathVariable Long id) throws CollectionNotFoundException {
        double score = collectionService.calculateCollectionImpact(id);
        return ResponseEntity.ok(score);
    }

}