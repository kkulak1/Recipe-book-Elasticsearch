package com.example.Recipe_book_Elastic.Recipe;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface RecipeRepository extends ElasticsearchRepository<Recipe, String> {
}
