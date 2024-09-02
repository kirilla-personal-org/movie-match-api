package ru.afanasyev.moviematch.app.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.afanasyev.moviematch.app.api.GetMovieOutbound;
import ru.afanasyev.moviematch.app.api.MovieNotFoundException;
import ru.afanasyev.moviematch.app.api.MovieRepository;
import ru.afanasyev.moviematch.domain.movie.Movie;

@Component
@RequiredArgsConstructor
@Slf4j
public class GetMovieUseCase implements GetMovieOutbound {
    private final MovieRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Movie getByName(String name) {
        return repository.findByName(name)
            .orElseThrow(() -> new MovieNotFoundException(name));
    }
}
