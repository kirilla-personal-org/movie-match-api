package ru.afanasyev.moviematch.app.api;

import ru.afanasyev.moviematch.domain.movie.Movie;

public interface GetMovieOutbound {
    Movie getRandomMovie();
}
