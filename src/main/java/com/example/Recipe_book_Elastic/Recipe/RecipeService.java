package com.example.Recipe_book_Elastic.Recipe;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public void save(final Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public Recipe findById(final String id) {
        return recipeRepository.findById(id).orElse(null);
    }
}
