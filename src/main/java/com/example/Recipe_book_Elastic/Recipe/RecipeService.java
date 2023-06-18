package com.example.Recipe_book_Elastic.Recipe;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.common.UUIDs;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class RecipeService {

    private static final String RECIPE_INDEX = "recipe";
    private ElasticsearchOperations elasticsearchOperations;
    private final RecipeRepository recipeRepository;

    public void save(final RecipeRequest recipeRequest) {
        Recipe recipe = new Recipe(
                UUIDs.base64UUID(),
                recipeRequest.getName(),
                recipeRequest.getDesc()
        );

        recipeRepository.save(recipe);
    }

    public Recipe findById(final String id) {
        return recipeRepository.findById(id).orElse(null);
    }

    public void findRecipeByName(String Recipename) {
        QueryBuilder queryBuilder =
                QueryBuilders.matchQuery("name", Recipename);

        Query searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();

        SearchHits<Recipe> recipeSearchHits =
                elasticsearchOperations.search(
                        searchQuery,
                        Recipe.class,
                        IndexCoordinates.of(RECIPE_INDEX)
                );
    }

}
