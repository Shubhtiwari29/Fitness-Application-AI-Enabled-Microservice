package com.fitness.service;

import com.fitness.model.Recommendation;
import com.fitness.repository.AiRecommendationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AiRecommendationService {

    private AiRecommendationRepository aiRecommendationRepository;

    public List<Recommendation> getUserRecommendation(String userId) {
        return aiRecommendationRepository.findByUserId(userId);
    }

    public Recommendation getActivityRecommendation(String activityId) {
        return aiRecommendationRepository.findByActivityId(activityId)
                .orElseThrow(() -> new RuntimeException("No recommendation found for this activity: " + activityId));
    }
}
