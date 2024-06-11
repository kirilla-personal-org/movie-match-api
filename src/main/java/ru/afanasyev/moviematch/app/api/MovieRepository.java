package ru.afanasyev.moviematch.app.api;

import ru.afanasyev.moviematch.domain.persistent.PersistentMovie;

import java.util.Optional;

public interface MovieRepository {
    long count();

    Optional<PersistentMovie> findByName(String name);
}
