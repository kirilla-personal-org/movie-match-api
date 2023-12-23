package ru.afanasyev.adapter.kinopoisk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.afanasyev.adapter.AbstractMovieAdapter;
import ru.afanasyev.adapter.kinopoisk.dto.MovieDomainMapper;
import ru.afanasyev.adapter.kinopoisk.dto.MovieDto;
import ru.afanasyev.app.api.MovieDataService;
import ru.afanasyev.domain.movie.Movie;

import java.util.Collections;

@Component
@Slf4j
public class KinopoiskAdapter extends AbstractMovieAdapter implements MovieDataService {
    private static final String KINOPOISK_URL = "https://api.kinopoisk.dev";
    private static final String TOKEN_HEADER_NAME = "X-API-KEY";

    private final MovieDomainMapper movieDomainMapper;

    public KinopoiskAdapter(KinopoiskTokenProvider tokenProvider, MovieDomainMapper movieDomainMapper) {
        super(tokenProvider);
        this.movieDomainMapper = movieDomainMapper;
    }

    @Override
    public Movie getRandomMovie() {
        log.info("Getting random movie from kinopoisk");
        MovieDto movieDto = buildRestTemplate("/v1/movie/random", HttpMethod.GET, MovieDto.class);
        return movieDomainMapper.mapToDomain(movieDto);
    }

    // ===================================================================================================================
    // = Implementation
    // ===================================================================================================================

    private <T> T buildRestTemplate(String path, HttpMethod method, Class<T> clazz) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set(TOKEN_HEADER_NAME, token);
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        return restTemplate.exchange(KINOPOISK_URL + path, method, entity, clazz).getBody();
    }
}
