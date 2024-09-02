package ru.afanasyev.moviematch.adapter.rest.v1.recommendation;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.afanasyev.moviematch.adapter.rest.v1.recommendation.dto.RecommendationDto;
import ru.afanasyev.moviematch.app.api.RecommendationService;
import ru.afanasyev.moviematch.domain.recommendation.Recommendation;

@RestController
@RequestMapping("/api/v1/external/recommendation")
@RequiredArgsConstructor
@Tag(name = "Контроллер Рекомендаций")
public class RecommendationExternalV1Controller {
    private RecommendationService recommendationService;

    @GetMapping("/init")
    public RecommendationDto initRecommendationProcess() {
        Recommendation recommendation = recommendationService.initRecommendationProcess();
        return new RecommendationDto(recommendation.getId());
    }
}
