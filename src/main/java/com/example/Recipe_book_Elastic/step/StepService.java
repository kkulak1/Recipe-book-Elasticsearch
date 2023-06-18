package com.example.Recipe_book_Elastic.step;

import com.example.Recipe_book_Elastic.Recipe.RecipeRepository;
import com.example.Recipe_book_Elastic.Recipe.RecipeService;
import lombok.AllArgsConstructor;
import org.elasticsearch.common.UUIDs;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StepService {
    private final StepRepository stepRepository;
    private final RecipeRepository recipeRepository;
    private final RecipeService recipeService;

    public void save(StepRequest stepRequest) {
        Step step = new Step(
                UUIDs.randomBase64UUID(),
                stepRequest.getSteps(),
                recipeService.findById(stepRequest.getRecipeId())
        );

        stepRepository.save(step);
    }

    public Step findById(Long id) {
        return stepRepository.findById(id).orElse(null);
    }
}

