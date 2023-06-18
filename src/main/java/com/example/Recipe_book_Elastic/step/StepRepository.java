package com.example.Recipe_book_Elastic.step;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface StepRepository extends ElasticsearchRepository<Step, Long> {
}
