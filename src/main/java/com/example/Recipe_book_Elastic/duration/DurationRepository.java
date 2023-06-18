package com.example.Recipe_book_Elastic.duration;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DurationRepository extends ElasticsearchRepository<Duration, String> {
}
