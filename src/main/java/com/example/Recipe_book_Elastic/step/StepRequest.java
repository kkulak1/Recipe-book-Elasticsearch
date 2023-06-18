package com.example.Recipe_book_Elastic.step;

import com.example.Recipe_book_Elastic.Recipe.Recipe;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StepRequest {
    private String steps;
    private String recipeId;
}
