package upec.episen.eco.controllers.optimization;

import org.springframework.web.bind.annotation.*;
import upec.episen.eco.service.OptimizedConsumption.QuizService;

import java.util.Map;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }




    @PostMapping("/submit")
    public void submitConstraints(@RequestBody Map<Long, Double> constraints) {
        quizService.saveConstraints(constraints);
    }



    @GetMapping("/constraints")
    public Map<Long, Double> getConstraints() {
        return quizService.getMinUsageConstraints();
    }
}
