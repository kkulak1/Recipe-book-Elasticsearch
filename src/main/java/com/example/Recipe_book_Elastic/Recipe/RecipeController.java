package com.example.Recipe_book_Elastic.Recipe;

import com.example.Recipe_book_Elastic.search.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/elastic/recipe")
@AllArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;
    private final SearchService searchService;

    @PostMapping("/save")
    public void save(@RequestBody final RecipeRequest recipeRequest) {
        recipeService.save(recipeRequest);
    }

    @GetMapping("/{id}")
    public Recipe findById(@PathVariable final String id) {
        return recipeService.findById(id);
    }

    @GetMapping("/search")
    public List<Recipe> fetchByNameOrDesc(@RequestParam(required = false) String query) {
        List<Recipe> recipes = searchService.processSearch(query);
        return recipes;
    }
}
