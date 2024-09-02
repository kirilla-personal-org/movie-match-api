package ru.afanasyev.moviematch.app.api;

import ru.afanasyev.moviematch.domain.recommendation.Recommendation;

import java.util.UUID;

public interface RecommendationRepository {
    Recommendation save(Recommendation recommendation);

    Recommendation getById(UUID id);
}
