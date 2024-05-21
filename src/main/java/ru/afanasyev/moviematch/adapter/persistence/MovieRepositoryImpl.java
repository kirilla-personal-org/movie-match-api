package ru.afanasyev.moviematch.adapter.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.afanasyev.moviematch.app.api.MovieRepository;

@Repository
@RequiredArgsConstructor
public class MovieRepositoryImpl implements MovieRepository {
    private final MovieJpaRepository repository;

    @Override
    public long count() {
        return repository.count();
    }
}
