package com.example.Recipe_book_Elastic.Recipe;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recipe")
@AllArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @PostMapping("/save")
    public void save(@RequestBody final Recipe recipe) {
        recipeService.save(recipe);
    }

    @GetMapping("/{id}")
    public Recipe findById(@PathVariable final String id) {
        return recipeService.findById(id);
    }
}
