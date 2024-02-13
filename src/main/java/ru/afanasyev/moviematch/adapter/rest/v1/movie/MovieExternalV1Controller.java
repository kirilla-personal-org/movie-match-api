package ru.afanasyev.adapter.rest.v1.movie;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.afanasyev.adapter.rest.v1.movie.dto.MovieDto;
import ru.afanasyev.adapter.rest.v1.movie.dto.MovieDtoMapper;
import ru.afanasyev.app.api.MovieDataService;
import ru.afanasyev.domain.movie.Movie;

@RestController
@RequestMapping("/api/v1/external/movie")
@RequiredArgsConstructor
@Tag(name = "Контроллер фильмов")
public class MovieExternalV1Controller {
    private final MovieDataService movieDataService;
    private final MovieDtoMapper movieDtoMapper;

    @GetMapping("/random")
    public MovieDto getRandomMovie() {
        Movie movie = movieDataService.getRandomMovie();
        return movieDtoMapper.mapToDto(movie);
    }
}
