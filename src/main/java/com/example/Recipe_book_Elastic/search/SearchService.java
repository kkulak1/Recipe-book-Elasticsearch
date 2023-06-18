package com.example.Recipe_book_Elastic.search;

import com.example.Recipe_book_Elastic.Recipe.Recipe;
import com.example.Recipe_book_Elastic.Recipe.RecipeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class SearchService {
    private final RecipeRepository recipeRepository;
    private final ElasticsearchOperations elasticsearchOperations;
    public List<Recipe> processSearch(String query) {
        QueryBuilder queryBuilder = QueryBuilders
                .multiMatchQuery(query, "name", "description")
                .fuzziness(Fuzziness.AUTO);

        Query searchQuery = new NativeSearchQueryBuilder()
                .withFilter(queryBuilder)
                .build();

        SearchHits<Recipe> recipeSearchHits = elasticsearchOperations
                .search(searchQuery, Recipe.class, IndexCoordinates.of("recipe"));

        List<Recipe> recipeMatches = new ArrayList<Recipe>();

        recipeSearchHits.forEach(srchHit->{
            recipeMatches.add(srchHit.getContent());
        });

        return recipeMatches;
    }
}
