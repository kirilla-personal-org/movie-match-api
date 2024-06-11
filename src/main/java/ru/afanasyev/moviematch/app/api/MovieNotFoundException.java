package ru.afanasyev.moviematch.app.api;

public class MovieNotFoundException extends RuntimeException {
    private static final String MOVIE_BY_NAME_NOT_FOUND_MESSAGE = "Movie by name %s not found";

    public MovieNotFoundException(String name) {
        super(String.format(MOVIE_BY_NAME_NOT_FOUND_MESSAGE, name));
    }
}
