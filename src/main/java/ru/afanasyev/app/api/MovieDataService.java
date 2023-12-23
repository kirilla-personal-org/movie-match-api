package ru.afanasyev.app.api;

import ru.afanasyev.domain.movie.Movie;

public interface MovieDataService {
    Movie getRandomMovie();
}
