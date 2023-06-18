package com.example.Recipe_book_Elastic.duration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/elastic/duration")
@AllArgsConstructor
public class DurationController {

    private final DurationService durationService;

    @PostMapping("/save")
    public void save(@RequestBody final DurationRequest durationRequest) {
        durationService.save(durationRequest);
    }

    @GetMapping("/{id}")
    public Duration findById(@PathVariable final String id) {
        return durationService.findById(id);
    }

}
