package ru.afanasyev.moviematch.app.api;

import ru.afanasyev.moviematch.domain.movie.Movie;

public interface MovieDataService {
    Movie getRandomMovie();
}
