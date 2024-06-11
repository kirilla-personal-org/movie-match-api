package ru.afanasyev.moviematch.app.api;

import ru.afanasyev.moviematch.domain.persistent.PersistentMovie;

public interface GetMovieOutbound {
    PersistentMovie getByName(String name);
}
