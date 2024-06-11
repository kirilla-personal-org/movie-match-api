package ru.afanasyev.moviematch.adapter.kinopoisk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import ru.afanasyev.moviematch.adapter.AbstractMovieAdapter;
import ru.afanasyev.moviematch.adapter.kinopoisk.dto.MovieDomainMapper;
import ru.afanasyev.moviematch.adapter.kinopoisk.dto.MovieDto;
import ru.afanasyev.moviematch.app.api.GetRandomMovieOutbound;
import ru.afanasyev.moviematch.domain.movie.Movie;

@Component
@Slf4j
public class KinopoiskAdapter extends AbstractMovieAdapter implements GetRandomMovieOutbound {
    private final MovieDomainMapper movieDomainMapper;

    private final RestTemplateProvider restTemplateProvider;

    public KinopoiskAdapter(KinopoiskTokenProvider tokenProvider, MovieDomainMapper movieDomainMapper, RestTemplateProvider restTemplateProvider) {
        super(tokenProvider);
        this.movieDomainMapper = movieDomainMapper;
        this.restTemplateProvider = restTemplateProvider;
    }

    @Override
    public Movie getRandomMovie() {
        log.info("Getting random movie from kinopoisk");
        MovieDto movieDto = restTemplateProvider.build(token)
            .exchange("/v1/movie/random", HttpMethod.GET, MovieDto.class);
        return movieDomainMapper.mapToDomain(movieDto);
    }
}
