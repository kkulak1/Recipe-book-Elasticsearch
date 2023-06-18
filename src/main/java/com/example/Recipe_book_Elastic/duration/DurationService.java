package com.example.Recipe_book_Elastic.duration;

import lombok.AllArgsConstructor;
import org.elasticsearch.common.UUIDs;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DurationService {
    private final DurationRepository durationRepository;

    public void save(DurationRequest durationRequest) {
        Duration duration = new Duration(
                UUIDs.randomBase64UUID(),
                durationRequest.getAmiuntOfTime(),
                durationRequest.getUnit(),
                durationRequest.getRecipe()
        );

        durationRepository.save(duration);
    }

    public Duration findById(String id) {
        return durationRepository.findById(id).orElse(null);
    }
}
