package ru.afanasyev.moviematch.app.impl.recommendation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.afanasyev.moviematch.app.api.MovieRepository;
import ru.afanasyev.moviematch.app.api.RecommendationRepository;
import ru.afanasyev.moviematch.app.api.RecommendationService;
import ru.afanasyev.moviematch.domain.movie.Movie;
import ru.afanasyev.moviematch.domain.recommendation.Recommendation;
import ru.afanasyev.moviematch.domain.recommendation.RecommendationStatus;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecommendationServiceImpl implements RecommendationService {
    private final RecommendationRepository recommendationRepository;
    private final MovieRepository movieRepository;

    @Override
    @Transactional
    public Recommendation initRecommendationProcess() {
        Recommendation recommendation = createRecommendation();
        log.info("Init recommendation process recommendation id: {}", recommendation.getId());
        return recommendation;
    }

    // ===================================================================================================================
    // = Implementation
    // ===================================================================================================================

    private Recommendation createRecommendation() {
        List<Movie> movies = movieRepository.findAll();
        Recommendation recommendation = new Recommendation()
            .setRecommendationStatus(RecommendationStatus.CREATED)
            .setMovies(movies);
        return recommendationRepository.save(recommendation);
    }
}
