package it;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.afanasyev.moviematch.adapter.persistence.MovieJpaRepository;
import ru.afanasyev.moviematch.app.api.RecommendationService;
import ru.afanasyev.moviematch.domain.movie.Movie;
import ru.afanasyev.moviematch.domain.recommendation.Recommendation;

class RecommendationProcessTest extends AbstractIntegrationTest {
    @Autowired
    private RecommendationService recommendationService;
    @Autowired
    private MovieJpaRepository movieJpaRepository;

    @Test
    void test() throws InterruptedException {
        movieJpaRepository.save(new Movie().setName("lol").setLength(10));
        Recommendation recommendation = recommendationService.initRecommendationProcess();
        Thread.sleep(5000);
    }
}
