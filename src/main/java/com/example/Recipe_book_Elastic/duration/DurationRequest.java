package com.example.Recipe_book_Elastic.duration;

import com.example.Recipe_book_Elastic.Recipe.Recipe;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DurationRequest {
    private Long amiuntOfTime;
    private String unit;
    private Recipe recipe;
}
