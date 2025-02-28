package upec.episen.eco.service.OptimizedConsumption;

import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/quiz")
public class MinUsageConstraintsService {

    private final Map<Long, Double> minUsageConstraints = new ConcurrentHashMap<>();

    @PostMapping("/submit")
    public void submitConstraints(@RequestBody Map<Long, Double> constraints) {
        minUsageConstraints.putAll(constraints);
    }

    @GetMapping("/constraints")
    public Map<Long, Double> getConstraints() {
        return minUsageConstraints;
    }
}