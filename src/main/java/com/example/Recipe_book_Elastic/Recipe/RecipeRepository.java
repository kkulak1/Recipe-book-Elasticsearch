package com.example.Recipe_book_Elastic.Recipe;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface RecipeRepository extends ElasticsearchRepository<Recipe, String> {
    List<Recipe> findByName(String name);

    List<Recipe> findByNameContaining(String name);

    List<Recipe> findByNameAndDescriptionContaining(String name, String description);
}
