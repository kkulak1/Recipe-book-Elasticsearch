package com.example.Recipe_book_Elastic.duration;

import com.example.Recipe_book_Elastic.Recipe.Recipe;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "duration")

public class Duration {
    @Id
    @Field(type = FieldType.Keyword)
    private Long id;
    @Field(type = FieldType.Long)
    private Long amountOfTime;
    @Field(type = FieldType.Text)
    private String unit;
    private Recipe recipe;
}
