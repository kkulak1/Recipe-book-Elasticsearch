package com.example.Recipe_book_Elastic.step;

import com.example.Recipe_book_Elastic.Recipe.Recipe;
import com.example.Recipe_book_Elastic.Recipe.RecipeRequest;
import com.example.Recipe_book_Elastic.Recipe.RecipeService;
import com.example.Recipe_book_Elastic.search.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/elastic/step")
@AllArgsConstructor
public class StepController {
    private final StepService stepService;
    private final StepRepository stepRepository;

    @PostMapping("/save")
    public void save(@RequestBody final StepRequest stepRequest) {
        stepService.save(stepRequest);
    }

    @GetMapping("/{id}")
    public Step findById(@PathVariable final Long id) {
        return stepService.findById(id);
    }
}
