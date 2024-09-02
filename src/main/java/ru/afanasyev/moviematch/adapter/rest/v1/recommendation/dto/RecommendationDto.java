package ru.afanasyev.moviematch.adapter.rest.v1.recommendation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationDto {
    private UUID id;
}
