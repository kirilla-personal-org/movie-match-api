package ru.afanasyev.adapter.rest.v1.movie.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(name = "Информация о фильме")
public class MovieDto {
    @Schema(name = "Название фильма")
    private String name;
    private PosterDto poster;
    private List<GenreDto> genres;
    @Schema(name = "Год выпуска", example = "1999")
    private Integer year;
    private RatingDto rating;
    @Schema(name = "Длительность, мин.", example = "120")
    private Integer movieLength;
}
