package ru.afanasyev.moviematch.adapter.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.afanasyev.moviematch.app.api.MovieRepository;
import ru.afanasyev.moviematch.domain.movie.Movie;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MovieRepositoryImpl implements MovieRepository {
    private final MovieJpaRepository repository;

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public Optional<Movie> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Movie> findAll() {
        return repository.findAll();
    }
}
