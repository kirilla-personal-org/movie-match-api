package ru.afanasyev.moviematch.adapter.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.afanasyev.moviematch.app.api.RecommendationRepository;
import ru.afanasyev.moviematch.domain.recommendation.Recommendation;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class RecommendationRepositoryImpl implements RecommendationRepository {
    private final RecommendationJpaRepository repository;

    @Override
    public Recommendation save(Recommendation recommendation) {
        return repository.save(recommendation);
    }

    @Override
    public Recommendation getById(UUID id) {
        return repository.getById(id);
    }
}
