package ru.afanasyev.adapter.kinopoisk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import ru.afanasyev.adapter.AbstractMovieAdapter;
import ru.afanasyev.adapter.kinopoisk.dto.MovieDomainMapper;
import ru.afanasyev.adapter.kinopoisk.dto.MovieDto;
import ru.afanasyev.app.api.MovieDataService;
import ru.afanasyev.domain.movie.Movie;

import java.util.Collections;

@Component
@Slf4j
public class KinopoiskAdapter extends AbstractMovieAdapter implements MovieDataService {
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
