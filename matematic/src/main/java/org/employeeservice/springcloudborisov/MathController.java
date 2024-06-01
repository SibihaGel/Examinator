package org.employeeservice.springcloudborisov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MathController {

    @Autowired
    private MathService mathService;


    @GetMapping("/questions")
    public List<Question> getRandomQuestion(@RequestParam int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be a positive integer");
        }

        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            questions.add(mathService.getRandom());
        }
        return questions;
    }
}
