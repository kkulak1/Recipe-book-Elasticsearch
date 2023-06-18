package com.example.Recipe_book_Elastic.duration;

import com.example.Recipe_book_Elastic.Recipe.Recipe;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Document(indexName = "duration")
@Setting(settingPath = "static/es-settings.json")
@Getter
@Setter
@AllArgsConstructor
public class Duration {
    @Id
    @Field(type = FieldType.Keyword)
    private String id;

    @Field(type = FieldType.Long)
    private Long amountOfTime;

    @Field(type = FieldType.Text)
    private String unit;

    private Recipe recipe;
}
