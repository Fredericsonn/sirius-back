package upec.episen.eco.controllers.optimization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upec.episen.eco.exceptions.ConsumptionNotFoundException;
import upec.episen.eco.models.consumption.Consumption;
import upec.episen.eco.models.consumption.ConsumptionItem;
import upec.episen.eco.service.OptimizedConsumption.OptimizationService;
import upec.episen.eco.service.OptimizedConsumption.OptimizedConsumptionResult;
import upec.episen.eco.service.OptimizedConsumption.QuizService;
import upec.episen.eco.service.consumption.ConsumptionService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class OptimizationController {

    @Autowired
    private OptimizationService optimizationService;

    @Autowired
    private QuizService quizService;

    @Autowired
    private ConsumptionService consumptionService;


    @PostMapping("/quiz/constraints")
    public ResponseEntity<?> saveQuizConstraints(@RequestBody Map<String, Object> payload) {
        try {
            if (!payload.containsKey("consumptionID") || !payload.containsKey("constraints")) {
                return ResponseEntity.badRequest().body("Donnée manquante");
            }

            Long consumptionId = Long.parseLong(payload.get("consumptionId").toString());

            if (!(payload.get("constraints") instanceof Map)) {
                return ResponseEntity.badRequest().body("Le champ 'constraints' doit être une Map.");
            }
            Map<String, Double> constraints = (Map<String, Double>) payload.get("constraints");

            Map<Long, Double> longKeyConstraints = new HashMap<>();
            for (Map.Entry<String, Double> entry : constraints.entrySet()) {
                try {
                    longKeyConstraints.put(Long.parseLong(entry.getKey()), entry.getValue());
                } catch (NumberFormatException e) {
                    return ResponseEntity.badRequest().body("Clé de contrainte invalide : " + entry.getKey());
                }
            }


            quizService.saveConstraints(consumptionId, longKeyConstraints);
            return ResponseEntity.ok("Contraintes enregistrées avec succès");

        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("ID de consommation invalide : " + payload.get("consumptionId"));
        }  catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur interne est survenue : " + e.getMessage());
        }
    }





    @GetMapping("/consumptions/{consumptionId}")
    public ResponseEntity<?> getConsumption(@PathVariable Long consumptionId) {
        try {
            Consumption consumption = consumptionService.getConsumptionById(consumptionId);

            Map<String, Object> response = new HashMap<>();
            response.put("id", consumption.getId());
            response.put("name", consumption.getName());

            return ResponseEntity.ok(response);

        } catch (ConsumptionNotFoundException e) {
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Erreur lors de la récupération de la consommation : " + e.getMessage());
        }
    }





    @GetMapping("/consumptions/{consumptionId}/items")
    public ResponseEntity<?> getConsumptionItems(@PathVariable Long consumptionId) {
        try {
            List<ConsumptionItem> items = consumptionService.getConsumptionItemsByConsumption(consumptionId);
            return ResponseEntity.ok(items);

        } catch (ConsumptionNotFoundException e) {
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Erreur lors de la récupération de la consommation : " + e.getMessage());
        }
    }







    @PostMapping("/optimize/{consumptionId}")
    public ResponseEntity<?> optimize(@PathVariable Long consumptionId) {
        try {
            OptimizedConsumptionResult result = optimizationService.optimizeConsumption(consumptionId);

            Map<String, Object> response = new HashMap<>();
            response.put("optimizedFrequencies", result.getOptimizedFrequencies());
            response.put("consumptionId", result.getConsumption().getId());
            response.put("consumptionName", result.getConsumption().getName());
            response.put("savedCarbon", result.getSavedCarbon());

            return ResponseEntity.ok(response);
        } catch (ConsumptionNotFoundException e) {
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Erreur de l'optimisation : " + e.getMessage());
        }
    }
}