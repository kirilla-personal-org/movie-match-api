package ru.afanasyev.moviematch.app.api;

import ru.afanasyev.moviematch.domain.recommendation.Recommendation;

public interface RecommendationService {
    Recommendation initRecommendationProcess();
}
