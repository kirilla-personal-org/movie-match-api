package ru.afanasyev.moviematch.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.afanasyev.moviematch.domain.recommendation.Recommendation;

import java.util.UUID;

public interface RecommendationJpaRepository extends JpaRepository<Recommendation, UUID> {
    Recommendation getById(UUID id);
}
