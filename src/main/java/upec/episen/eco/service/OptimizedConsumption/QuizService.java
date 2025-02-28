package upec.episen.eco.service.OptimizedConsumption;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class QuizService {
    private final Map<Long, Double> minUsageConstraints = new HashMap<>();

    public void saveConstraints(Map<Long, Double> constraints) {
        minUsageConstraints.putAll(constraints);
    }

    public Map<Long, Double> getMinUsageConstraints() {
        return new HashMap<>(minUsageConstraints);
    }
}

