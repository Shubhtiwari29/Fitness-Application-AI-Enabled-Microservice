package com.fitness.controller;

import com.fitness.model.Recommendation;
import com.fitness.service.AiRecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recommendations")
public class AiRecommendationController {

        private final AiRecommendationService aiRecommendationService;

        @GetMapping("/user/{userId}")
            public ResponseEntity<List<Recommendation>> getUserRecommendations
                    (@PathVariable String userId){
                return ResponseEntity.ok(aiRecommendationService.getUserRecommendation(userId));
            }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<Recommendation> getActivityRecommendation(@PathVariable String activityId) {
        return ResponseEntity.ok(aiRecommendationService.getActivityRecommendation(activityId));
    }

}
