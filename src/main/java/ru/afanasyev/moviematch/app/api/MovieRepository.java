package ru.afanasyev.moviematch.app.api;

import ru.afanasyev.moviematch.domain.movie.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {
    long count();

    Optional<Movie> findByName(String name);

    List<Movie> findAll();
}
